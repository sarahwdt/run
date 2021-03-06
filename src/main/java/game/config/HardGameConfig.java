package game.config;

import game.core.behavior.move.*;
import game.core.objects.*;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.LinkedList;
import java.util.List;

/**
 * Конфигурация игрового движка для сложной игры
 */
public class HardGameConfig implements GameConfig {
    private final double SPAWN_RANGE = 1000;
    private final int BARRIERS_COUNT = 10;
    private final Canvas canvas;
    private final Actor actor;
    private final List<BasicObject> barriers = new LinkedList<>();
    private final List<BasicObject> locationObjects = new LinkedList<>();

    /**
     * Создание ресурсво для движка
     *
     * @param canvas холст для отрисовки игры
     */
    public HardGameConfig(Canvas canvas) {
        this.canvas = canvas;
        double floorY = canvas.getHeight() - canvas.getHeight() * 0.1;
        actor = new Actor(70, floorY, Color.GREEN, 50);
        actor.getMoves().add(new JumpMove(0));
        actor.getMoves().add(new LeftMove(50));
        actor.getMoves().add(new RightMove(canvas.getWidth()));

        Floor floor = new Floor(0, floorY, Color.TEAL, canvas.getWidth() + 1, canvas.getHeight() * 0.1);

        Cube basicCube = new Cube(-200, floorY, Color.BROWN, 75);
        Cube fastNSmollCube = new Cube(-200, floorY, Color.RED, 30);

        Rectangle heavyRectangle = new Rectangle(-200, floorY, Color.BLUE, 150, 30);
        EnemyCircle jumpingCircle = new EnemyCircle(-200, floorY, Color.ORANGE, 35);
        EnemyCircle flyingCircle = new EnemyCircle(-200, floorY - 250, Color.RED, 30);


        basicCube.getMoves().add(new RunImitationMove(2, 0.0005, 4));
        fastNSmollCube.getMoves().add(new RunImitationMove(3, 0.005, 5));
        heavyRectangle.getMoves().add(new RunImitationMove(1, 0.00005, 5));
        jumpingCircle.getMoves().add(new RunImitationMove(1, 0.0005, 4));
        flyingCircle.getMoves().add(new RunImitationMove(1, 0.005, 2));

        jumpingCircle.getMoves().add(new RandomJumpMovie());


        locationObjects.add(floor);
        barriers.add(new Cube(basicCube));
        barriers.add(new Cube(basicCube));
        barriers.add(new Cube(basicCube));

        barriers.add(new Cube(fastNSmollCube));
        barriers.add(new Cube(fastNSmollCube));
        barriers.add(new Cube(fastNSmollCube));
        barriers.add(new Cube(fastNSmollCube));
        barriers.add(new Cube(fastNSmollCube));


        barriers.add(new Rectangle(heavyRectangle));
        barriers.add(new Rectangle(heavyRectangle));

        barriers.add(new EnemyCircle(jumpingCircle));
        barriers.add(new EnemyCircle(jumpingCircle));
        barriers.add(new EnemyCircle(jumpingCircle));

        barriers.add(new EnemyCircle(flyingCircle));
        barriers.add(new EnemyCircle(flyingCircle));
        barriers.add(new EnemyCircle(flyingCircle));
        barriers.add(new EnemyCircle(flyingCircle));
        barriers.add(new EnemyCircle(flyingCircle));

    }

    /**
     * @return список доступных для спавна барьеров
     */
    @Override
    public List<BasicObject> getAvailableBarriers() {
        return barriers;
    }

    /**
     * @return список доступных для спавна объектов окружения
     */
    @Override
    public List<BasicObject> getLocationObjects() {
        return locationObjects;
    }

    /**
     * @return объект которым управляет игрок
     */
    @Override
    public Actor getActor() {
        return actor;
    }

    /**
     * @return размер арены для спавна(увеличивает среднее растояние между оьбъектами)
     */
    @Override
    public double getSpawnRange() {
        return SPAWN_RANGE;
    }

    /**
     * @return холст
     */
    @Override
    public Canvas getCanvas() {
        return canvas;
    }

    /**
     * @return количество одноременно заспавненных барьеров(уменьшает среднее расстояние между объектами)
     */
    @Override
    public int getBarriersCount() {
        return BARRIERS_COUNT;
    }
}
