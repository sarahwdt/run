package game.core.objects.abstractions;

import javafx.scene.shape.Shape;

/**
 * Интерфейс определяющий физическую модель объекта
 */
public interface Collided {
    /**
     * @return физическая модель
     */
    Shape getShape();
}
