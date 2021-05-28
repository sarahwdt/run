package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;

public class ScoreCyclicService extends BasicCyclicService {
    private long period;
    private double store = 0;

    public ScoreCyclicService(GameEngine engine, long period) {
        super(engine);
        this.period = period;
    }

    @Override
    public void execute() {
        store += period;
        if(store >= 1000) {
            engine.setScore(engine.getScore() + 1);
            store = 0;
        }
    }

    @Override
    public void reset(GameConfig gameConfig) {
        store = 0;
        engine.setScore(0);
    }
}
