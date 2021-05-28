package game.core.service.cyclic;

import game.core.GameEngine;
import game.objects.abstractions.Collided;
import game.objects.abstractions.Controlable;
import javafx.scene.shape.Shape;

public class CollisionCyclicService extends BasicCyclicService {
    public CollisionCyclicService(GameEngine engine) {
        super(engine);
    }

    @Override
    protected synchronized void execute() {
        engine.getObjectHub().getObjects().stream()
                .filter(object -> object instanceof Controlable && object instanceof Collided)
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
}
