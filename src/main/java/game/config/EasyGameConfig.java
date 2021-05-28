package game.config;

import game.core.behavior.move.JumpMove;
import game.core.behavior.move.RandomJumpMovie;
import game.core.behavior.move.RunImitationMove;
import game.core.objects.*;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

import java.util.*;

public class EasyGameConfig implements GameConfig {
    private final int BARRIER_COUNT = 0;
    private final double SPAWN_RANGE = 500;
    private final Canvas canvas;
    private final Actor actor;
    private final Set<BasicObject> barriers = new HashSet<>();
    private final List<BasicObject> locationObjects = new LinkedList<>();

    public EasyGameConfig(Canvas canvas) {
        this.canvas = canvas;
        double floorY = canvas.getHeight() - canvas.getHeight()*0.1;
        actor = new Actor(70, floorY, Color.SIENNA, 50);
        Floor floor = new Floor(0, floorY, Color.TEAL, canvas.getWidth() + 1, canvas.getHeight() * 0.1);
        Cube barrierTypeOne = new Cube(canvas.getWidth() + 100, floorY, Color.RED, 100);
        Rectangle barrierTypeTwo = new Rectangle(canvas.getWidth() + 100, floorY, Color.DARKMAGENTA, 100, 200);
        Circle barrierTypeThree = new Circle(canvas.getWidth() + 100, floorY, Color.GHOSTWHITE, 60);
        actor.getMoves().add(new JumpMove(5));
        barrierTypeOne.getMoves().add(new RunImitationMove(1, 0.001, 4));
        barrierTypeTwo.getMoves().add(new RunImitationMove(0.5, 0.0005, 5));
        barrierTypeThree.getMoves().add(new RunImitationMove(3, 0.005, 4));
        barrierTypeThree.getMoves().add(new RandomJumpMovie());
        locationObjects.add(floor);
        barriers.add(barrierTypeOne);
        barriers.add(barrierTypeThree);
        barriers.add(barrierTypeOne);
    }

    @Override
    public Set<BasicObject> getAvailableBarriers() {
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
    public int getBarrierCount() {
        return BARRIER_COUNT;
    }


    @Override
    public double getSpawnRange() {
        return SPAWN_RANGE;
    }

    @Override
    public Canvas getCanvas() {
        return canvas;
    }
}
