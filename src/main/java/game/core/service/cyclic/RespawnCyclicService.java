package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;
import game.core.objects.abstractions.BasicObject;
import game.core.objects.abstractions.Movable;
import game.core.objects.abstractions.Respawned;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.random;

/**
 * Сервис респавна объектов
 */
public class RespawnCyclicService extends BasicCyclicService {
    private double range;

    public RespawnCyclicService(GameEngine engine, double range) {
        super(engine);
        this.range = range;
    }

    @Override
    public void execute() {
        List<BasicObject> objects = engine.getObjectHub().getObjects();
        synchronized (engine.getObjectHub().getObjects()){
            objects.stream()
                    .filter(object -> object instanceof Respawned)
                    .filter(object -> object.getX() < engine.getXMin() - 200)
                    .forEach(this::respawn);
        }
    }

    @Override
    public void reset(GameConfig gameConfig) {
        range = gameConfig.getSpawnRange();
    }

    private void respawn(BasicObject object) {
        synchronized (engine.getObjectHub().getObjects()){
            engine.getObjectHub().getObjects().replaceAll(basicObject -> {
                if (basicObject == object) {
                    BasicObject newObject;
                    do {
                        int random = (int) (100 * random()) % engine.getObjectHub().getAvailableBarriers().size();
                        newObject = engine.getObjectHub().getAvailableBarriers()
                                .get(random);
                    } while (engine.getObjectHub().getObjects().contains(newObject));
                    newObject.setX(engine.getXMax() + (range * random()));
                    return newObject;
                } else return basicObject;
            });
        }
    }
}
