package game.config;

import game.core.objects.Actor;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;

import java.util.List;

/**
 * Интерфейс конфигурации игрового движка для простой игры
 */
public interface GameConfig {
    /**
     * @return список доступных для спавна барьеров
     */
    List<BasicObject> getAvailableBarriers();

    /**
     * @return список доступных для спавна объектов окружения
     */
    List<BasicObject> getLocationObjects();

    /**
     * @return объект которым управляет игрок
     */
    Actor getActor();

    /**
     * @return размер арены для спавна(увеличивает среднее растояние между оьбъектами)
     */
    double getSpawnRange();

    /**
     * @return холст
     */
    Canvas getCanvas();

    /**
     * @return количество одноременно заспавненных барьеров(уменьшает среднее расстояние между объектами)
     */
    int getBarriersCount();
}
