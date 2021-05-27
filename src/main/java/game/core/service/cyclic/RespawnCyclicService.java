package game.core.service.cyclic;

import game.core.GameEngine;
import game.objects.abstractions.BasicObject;
import game.objects.abstractions.Reusable;

import static java.lang.Math.random;

public class RespawnCyclicService extends BasicCyclicService {
    private double range;
    public RespawnCyclicService(GameEngine engine, double range) {
        super(engine);
        this.range = range;
    }

    @Override
    public void run() {
        engine.getObjectHub().getObjects().stream()
                .filter(object -> object instanceof Reusable)
                .filter(object -> object.getX() < engine.getXMin())
                .forEach(this::respawn);
    }

    private void respawn(BasicObject object){
        object.setX(engine.getXMax() + (range*random()));
        System.out.println("respawn");
    }

    public double getRange() {
        return range;
    }

    public void setRange(double range) {
        this.range = range;
    }
}
