package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;
import game.core.objects.abstractions.BasicObject;
import game.core.objects.abstractions.Movable;
import game.core.objects.abstractions.Respawned;
import game.core.service.ObjectHub;

import java.util.List;

import static java.lang.Math.random;

public class RespawnCyclicService extends BasicCyclicService {
    private double range;
    private int barricadesCount;

    public RespawnCyclicService(GameEngine engine, double range, int barricadesCount) {
        super(engine);
        this.range = range;
        this.barricadesCount = barricadesCount;
    }

    @Override
    public synchronized void execute() {
        List<BasicObject> objects = engine.getObjectHub().getObjects();
        objects.stream()
                .filter(object -> object instanceof Respawned)
                .filter(object -> object.getX() < engine.getXMin() - 200)
                .forEach(objects::remove);
        long barricadesNow = objects.stream().filter(basicObject ->
                basicObject instanceof Respawned && basicObject instanceof Movable).count();
        for(long i = barricadesNow; barricadesNow<=barricadesCount;i++){
            BasicObject object = engine.getObjectHub().getAvailableBarriers().stream().findAny().get();
            respawn(object);
            objects.add(object);
        }
    }

    @Override
    public void reset(GameConfig gameConfig) {
        range = gameConfig.getSpawnRange();
        barricadesCount = gameConfig.getBarrierCount();
    }

    private void respawn(BasicObject object) {
        object.setX(engine.getXMax() + (range * random()));
    }

}
