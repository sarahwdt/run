package game.config;

import game.core.behavior.move.*;
import game.core.objects.*;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.*;

public class EasyGameConfig implements GameConfig {
    private final double SPAWN_RANGE = 500;
    private final int BARRIERS_COUNT = 3;
    private final Canvas canvas;
    private final Actor actor;
    private final List<BasicObject> barriers = new LinkedList<>();
    private final List<BasicObject> locationObjects = new LinkedList<>();

    public EasyGameConfig(Canvas canvas) {
        this.canvas = canvas;
        double floorY = canvas.getHeight() - canvas.getHeight()*0.1;
        actor = new Actor(70, floorY, Color.GREEN, 50);
        Floor floor = new Floor(0, floorY, Color.TEAL, canvas.getWidth() + 1, canvas.getHeight() * 0.1);
        Cube barrierTypeOne = new Cube(-200, floorY, Color.RED, 75);
        Rectangle barrierTypeTwo = new Rectangle(-200, floorY, Color.BLUE, 150, 50);
        EnemyCircle barrierTypeThree = new EnemyCircle(-200, floorY, Color.RED, 35);
        actor.getMoves().add(new JumpMove(5));
        actor.getMoves().add(new LeftMove(50));
        actor.getMoves().add(new RightMove(canvas.getWidth()/2));
        barrierTypeOne.getMoves().add(new RunImitationMove(1, 0.0001, 4));
        barrierTypeTwo.getMoves().add(new RunImitationMove(1, 0.00005, 5));
        barrierTypeThree.getMoves().add(new RunImitationMove(1, 0.0005, 4));
        barrierTypeThree.getMoves().add(new RandomJumpMovie());
        locationObjects.add(floor);
        barriers.add(barrierTypeOne);
        barriers.add(new Cube(barrierTypeOne));
        barriers.add(new Cube(barrierTypeOne));
        barriers.add(barrierTypeThree);
        barriers.add(barrierTypeTwo);
        barriers.add(new Rectangle(barrierTypeTwo));
    }

    @Override
    public List<BasicObject> getAvailableBarriers() {
        return barriers;
    }

    @Override
    public List<BasicObject> getLocationObjects() {
        return locationObjects;
    }

    @Override
    public Actor getActor() {
        return actor;
    }


    @Override
    public double getSpawnRange() {
        return SPAWN_RANGE;
    }

    @Override
    public Canvas getCanvas() {
        return canvas;
    }

    @Override
    public int getBarriersCount() {
        return BARRIERS_COUNT;
    }
}
