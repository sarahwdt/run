package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;
import game.core.objects.abstractions.Movable;

/**
 * Сервис обработки движения
 */
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

    @Override
    public void reset(GameConfig gameConfig) {

    }
}
