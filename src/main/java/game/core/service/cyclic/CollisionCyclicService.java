package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;
import game.core.objects.abstractions.Collided;
import game.core.objects.abstractions.PlayerControlled;

public class CollisionCyclicService extends BasicCyclicService {
    public CollisionCyclicService(GameEngine engine) {
        super(engine);
    }

    @Override
    protected synchronized void execute() {
        engine.getObjectHub().getObjects().stream()
                .filter(object -> object instanceof PlayerControlled && object instanceof Collided)
                .map(object -> (Collided) object)
                .forEach(actor -> engine.getObjectHub().getObjects().stream()
                        .filter(object -> object instanceof Collided && object != actor)
                        .map(object -> (Collided) object)
                        .forEach(object -> {
                            if(actor.getShape().getBoundsInParent().intersects(
                                    object.getShape().getBoundsInParent())) {
                                engine.stop();
                            }
                        }));
    }

    @Override
    public void reset(GameConfig gameConfig) {

    }
}
