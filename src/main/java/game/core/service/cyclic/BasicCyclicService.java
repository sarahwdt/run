package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;

import java.util.TimerTask;

public abstract class BasicCyclicService extends TimerTask {
    protected GameEngine engine;
    protected boolean run = true;

    public BasicCyclicService(GameEngine engine) {
        this.engine = engine;
    }

    @Override
    public synchronized void run() {
        if (run) execute();
    }

    protected abstract void execute();

    public abstract void reset(GameConfig gameConfig);

    public synchronized void stop() {
        run = false;
    }

    public synchronized void start() {
        run = true;
    }
}
