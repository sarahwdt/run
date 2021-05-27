package game.core.service.cyclic;

import game.core.GameEngine;

public class ScoreCyclicService extends BasicCyclicService {

    public ScoreCyclicService(GameEngine engine) {
        super(engine);
    }

    @Override
    public void run() {
        engine.setScore(engine.getScore() + 1000/16);
    }
}
