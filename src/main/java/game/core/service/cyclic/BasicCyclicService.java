package game.core.service.cyclic;

import game.core.GameEngine;

import java.util.TimerTask;

public abstract class BasicCyclicService extends TimerTask {
    protected GameEngine engine;

    public BasicCyclicService(GameEngine engine) {
        this.engine = engine;
    }
}
