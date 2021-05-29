package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;
import game.core.objects.abstractions.Drawable;

public class DrawCyclicService extends BasicCyclicService {
    public DrawCyclicService(GameEngine engine) {
        super(engine);
    }

    @Override
    public void execute() {
        if (engine.getGraphicsContext() == null) return;
        engine.getGraphicsContext().clearRect(engine.getXMin(), engine.getYMin(),
                engine.getXMax(), engine.getYMax());
        engine.getObjectHub().getObjects().stream()
                .filter(object -> object instanceof Drawable)
                .forEach(object -> ((Drawable) object).draw(engine.getGraphicsContext()));
    }

    @Override
    public void reset(GameConfig gameConfig) {

    }
}
