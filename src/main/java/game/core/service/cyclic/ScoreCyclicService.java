package game.core.service.cyclic;

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
        store += 1000.0/period;
        if(store >= 1000) {
            engine.setScore(engine.getScore() + 1);
            store = 0;
        }
    }
}
