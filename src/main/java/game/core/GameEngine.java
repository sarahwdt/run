package game.core;

import game.core.service.ObjectHub;
import game.core.service.cyclic.*;
import game.objects.Circle;
import game.objects.Cube;
import game.objects.Floor;
import game.objects.abstractions.Controlable;
import game.objects.abstractions.Movable;
import game.objects.behavior.move.CubeMove;
import game.objects.behavior.move.JumpMove;
import javafx.application.Platform;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.function.Consumer;

public class GameEngine {
    private int score = 0;
    private final ObjectHub objectHub = new ObjectHub();
    private GraphicsContext graphicsContext;
    private Canvas canvas;
    private Label scoreLabel;
    private boolean active = true;
    private final List<BasicCyclicService> services = new LinkedList<>();
    private final Timer cyclicServiceScheduler = new Timer("Cyclic-services-scheduler", true);

    private final Consumer<Movable> jumpAction = new Consumer<Movable>() {
        @Override
        public void accept(Movable movable) {
            movable.getMoves().stream()
                    .filter(move -> move instanceof JumpMove)
                    .map(move -> (JumpMove)move)
                    .forEach(jumpMove -> {
                        if(!jumpMove.isActive()) jumpMove.jumpOnFloor(6);
                        else jumpMove.jumpOnAir(5);
                    });
        }
    };

    public GameEngine(Canvas canvas) {
        this.canvas = canvas;
        this.graphicsContext = canvas.getGraphicsContext2D();
        initObjects();
        initServices();
    }

    //region init
    private void initObjects() {
        objectHub.getObjects().add(new Floor(0, canvas.getHeight() - canvas.getHeight() * 0.1,
                Color.TEAL, canvas.getWidth(), canvas.getHeight() * 0.1));
        Circle actor = new Circle(getXMin() + 60, canvas.getHeight() - canvas.getHeight() * 0.1, Color.GREEN, 50);
        actor.getMoves().add(new JumpMove(5, getYMax()));
        objectHub.getObjects().add(actor);

        List<Cube> enemies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Cube enemy = new Cube(getYMax() + 300 * i, canvas.getHeight() - canvas.getHeight() * 0.1 - 50,
                    Color.RED, 50);
            enemy.getMoves().add(new CubeMove());
            enemies.add(enemy);
        }
        objectHub.getObjects().addAll(enemies);
    }

    private void initServices() {
        services.add(new ScoreCyclicService(this, 16));
        services.add(new MoveCyclicService(this));
        services.add(new DrawCyclicService(this));
        services.add(new RespawnCyclicService(this, 200));
        services.add(new CollisionCyclicService(this));
        for (BasicCyclicService service : services) cyclicServiceScheduler.schedule(service, 0, 16);
    }
    //endregion

    //region control

    public void stop() {
        active = false;
        for (BasicCyclicService service : services) service.stop();
    }

    public void start() {
        active = true;
        for (BasicCyclicService service : services) service.start();
    }

    public void restart(){
        stop();
    }

    public void scale(double ratio) {
        objectHub.getObjects().forEach(object -> object.scale(ratio));
    }

    public void input(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case CONTROL:
                objectHub.getObjects().stream()
                        .filter(object -> object instanceof Controlable && object instanceof Movable)
                        .map(object -> (Movable) object)
                        .forEach(jumpAction);
                break;
            case A:
            case LEFT:
            case D:
            case RIGHT:
            default:
        }
    }
    //endregion

    //region getters'n'setters
    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                scoreLabel.setText(String.valueOf(score));
            }
        });
    }

    public ObjectHub getObjectHub() {
        return objectHub;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public void setGraphicsContext(GraphicsContext graphicsContext) {
        this.graphicsContext = graphicsContext;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public void setCanvas(Canvas canvas) {
        this.canvas = canvas;
    }

    public double getXMax() {
        return canvas.getWidth();
    }

    public double getYMax() {
        return canvas.getHeight();
    }

    public double getXMin() {
        return 0;
    }

    public double getYMin() {
        return 0;
    }

    public void setScoreLabel(Label scoreLabel) {
        this.scoreLabel = scoreLabel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
    //endregion
}
