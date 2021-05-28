package game.core.service.cyclic;

import game.core.GameEngine;
import game.objects.abstractions.Movable;

public class MoveCyclicService extends BasicCyclicService {
    public MoveCyclicService(GameEngine engine) {
        super(engine);
    }

    @Override
    public void execute() {
        engine.getObjectHub().getObjects().stream()
                .filter(object -> object instanceof Movable)
                .forEach(object -> ((Movable) object).getMoves()
                        .forEach(move -> move.move(object)));
    }
}
