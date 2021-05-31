package game.core.service.cyclic;

import game.config.GameConfig;
import game.core.GameEngine;

import java.util.TimerTask;

/**
 * Абстрактный объект цикличесокго сервиса
 */
public abstract class BasicCyclicService extends TimerTask {
    protected GameEngine engine;
    protected boolean run = true;

    /**
     * Инициализация
     * @param engine игровой движок
     */
    public BasicCyclicService(GameEngine engine) {
        this.engine = engine;
    }

    /**
     * Основной исполяемый метод
     */
    @Override
    public synchronized void run() {
        if (run) execute();
    }

    /**
     * Метод для разширения
     */
    protected abstract void execute();

    /**
     * Перезапуск сервиса
     * @param gameConfig конфигурация
     */
    public abstract void reset(GameConfig gameConfig);

    /**
     * Метод остановки сервиса
     */
    public synchronized void stop() {
        run = false;
    }

    /**
     * Метод запуска сервиса после остановки
     */
    public synchronized void start() {
        run = true;
    }
}
