package game.core.service;

import game.config.GameConfig;
import game.core.objects.abstractions.BasicObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Менеджер объектов
 */
public class ObjectHub {
    /**
     * @return список объектов в игре
     */
    public List<BasicObject> getObjects() {
        return objects;
    }

    private final List<BasicObject> objects = new LinkedList<>();
    private List<BasicObject> barricades = new LinkedList<>();

    /**
     * Перезапуск объектов
     *
     * @param gameConfig конфигурация игры
     */
    public void reset(GameConfig gameConfig) {
        barricades = gameConfig.getAvailableBarriers();
        objects.clear();
        objects.add(gameConfig.getActor());
        for (int i = 0; i < gameConfig.getBarriersCount(); i++) {
            objects.add(gameConfig.getAvailableBarriers().get(i));
        }
        objects.addAll(gameConfig.getLocationObjects());
        objects.forEach(BasicObject::reset);
    }

    /**
     * @return список допустимых препятствий
     */
    public List<BasicObject> getAvailableBarriers() {
        return barricades;
    }
}
