package game.core;

import game.config.GameConfig;
import game.core.behavior.move.JumpMove;
import game.core.behavior.move.LeftMove;
import game.core.behavior.move.RightMove;
import game.core.objects.abstractions.Movable;
import game.core.objects.abstractions.PlayerControlled;
import game.core.service.ObjectHub;
import game.core.service.cyclic.*;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.function.Consumer;

/**
 * Игровой движок
 */
public class GameEngine {
    private boolean active = true;

    private GraphicsContext graphicsContext;
    private final Canvas canvas;
    private int score = 0;
    private Label scoreLabel;

    private GameConfig gameConfig;
    private final ObjectHub objectHub = new ObjectHub();
    private final List<BasicCyclicService> services = new LinkedList<>();
    private final Timer cyclicServiceScheduler = new Timer("Cyclic-services-scheduler", true);

    /**
     * Обработчик события кнопки прыжка
     */
    private final Consumer<Movable> jumpAction = new Consumer<Movable>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof JumpMove)
                    .map(move -> (JumpMove) move)
                    .forEach(jumpMove -> {
                        if (!jumpMove.isActive()) jumpMove.jumpOnFloor(12);
                        else jumpMove.jumpOnAir(8);
                    });
        }
    };

    /**
     * Обработчик события кнопки движения вправо
     */
    private final Consumer<Movable> rightBegin = new Consumer<>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof RightMove)
                    .map(move -> (RightMove) move)
                    .forEach(rightMove -> rightMove.begin(2));
        }
    };

    /**
     * Обработчик события кнопки движения влево
     */
    private final Consumer<Movable> leftBegin = new Consumer<Movable>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof LeftMove)
                    .map(move -> (LeftMove) move)
                    .forEach(leftMove -> leftMove.begin(2));
        }
    };

    /**
     * Обработчик события кнопки движения влево
     */
    private final Consumer<Movable> leftStop = new Consumer<Movable>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof LeftMove)
                    .map(move -> (LeftMove) move)
                    .forEach(LeftMove::stop);
        }
    };

    /**
     * Обработчик события кнопки движения вправо
     */
    private final Consumer<Movable> rightStop = new Consumer<Movable>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof RightMove)
                    .map(move -> (RightMove) move)
                    .forEach(RightMove::stop);
        }
    };

    /**
     * Инициализация движка
     *
     * @param gameConfig конфигурация
     */
    public GameEngine(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
        this.canvas = gameConfig.getCanvas();
        this.graphicsContext = gameConfig.getCanvas().getGraphicsContext2D();
        initObjects();
        initServices();
    }

    //region init

    /**
     * Инициализация объектов
     */
    private void initObjects() {
        objectHub.reset(gameConfig);
    }

    /**
     * Инициализация сервисов
     */
    private void initServices() {
        services.add(new ScoreCyclicService(this, 16));
        services.add(new MoveCyclicService(this));
        services.add(new DrawCyclicService(this));
        services.add(new RespawnCyclicService(this, gameConfig.getSpawnRange()));
        services.add(new CollisionCyclicService(this));
        for (BasicCyclicService service : services) cyclicServiceScheduler.schedule(service, 0, 16);
    }
    //endregion

    //region control

    /**
     * Остановка движка
     */
    public void stop() {
        active = false;
        for (BasicCyclicService service : services) service.stop();
    }

    /**
     * Запуск движка
     */
    public void start() {
        active = true;
        for (BasicCyclicService service : services) service.start();
    }

    /**
     * Перезапуск движка
     */
    public void restart() {
        stop();
        objectHub.reset(gameConfig);
        services.forEach(basicCyclicService -> basicCyclicService.reset(gameConfig));
        start();
    }

    /**
     * Изменение масштаба
     *
     * @param ratio множитель
     */
    public void scale(double ratio) {
        objectHub.getObjects().forEach(object -> object.scale(ratio));
    }

    /**
     * Обработчик пользовательского ввода
     *
     * @param keyEvent событие
     */
    public void input(KeyEvent keyEvent) {
        Consumer<Movable> action = new Consumer<Movable>() {
            @Override
            public void accept(Movable movable) {

            }
        };
        switch (keyEvent.getCode()) {
            case W:
            case UP:
                if (KeyEvent.KEY_PRESSED.equals(keyEvent.getEventType()))
                    objectHub.getObjects().stream()
                            .filter(object -> object instanceof PlayerControlled && object instanceof Movable)
                            .map(object -> (Movable) object)
                            .forEach(jumpAction);
                break;
            case A:
            case LEFT:
                if (KeyEvent.KEY_PRESSED.equals(keyEvent.getEventType()))
                    action = leftBegin;
                else
                    action = leftStop;
                objectHub.getObjects().stream()
                        .filter(object -> object instanceof PlayerControlled && object instanceof Movable)
                        .map(object -> (Movable) object)
                        .forEach(action);
                break;
            case D:
            case RIGHT:
                if (KeyEvent.KEY_PRESSED.equals(keyEvent.getEventType()))
                    action = rightBegin;
                else
                    action = rightStop;
                objectHub.getObjects().stream()
                        .filter(object -> object instanceof PlayerControlled && object instanceof Movable)
                        .map(object -> (Movable) object)
                        .forEach(action);
                break;
            default:
        }
    }
    //endregion

    //region getters'n'setters

    /**
     * @return текущий счет
     */
    public int getScore() {
        return score;
    }

    /**
     * Установка счета в строку счета
     *
     * @param score значение счета
     */
    public void setScore(int score) {
        this.score = score;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                scoreLabel.setText(String.valueOf(score));
            }
        });
    }

    /**
     * @return менеджер объектов
     */
    public ObjectHub getObjectHub() {
        return objectHub;
    }

    /**
     * @return графический контекст
     */
    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    /**
     * @return холст
     */
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * @return правая граница поля
     */
    public double getXMax() {
        return canvas.getWidth();
    }

    /**
     * @return нижняя граница поля
     */
    public double getYMax() {
        return canvas.getHeight();
    }

    /**
     * @return левая граница поля
     */
    public double getXMin() {
        return 0;
    }

    /**
     * @return верхняя граница поля
     */
    public double getYMin() {
        return 0;
    }

    /**
     * Установка строки для отрисовки счета
     *
     * @param scoreLabel объект строки
     */
    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    /**
     * @return текущая конфигурация
     */
    public GameConfig getGameConfig() {
        return gameConfig;
    }

    /**
     * Установка игровой конфигурации
     *
     * @param gameConfig конфигурация
     */
    public void setGameConfig(GameConfig gameConfig) {
        this.gameConfig = gameConfig;
    }
    //endregion
}
