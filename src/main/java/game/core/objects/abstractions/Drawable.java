package game.core.objects.abstractions;

import javafx.scene.canvas.GraphicsContext;

/**
 * Интерфейс определяющий способ отрисовки объекта
 */
public interface Drawable {
    /**
     * Способ отрисовки
     * @param gc графический контекст("крандаш")
     */
    void draw(GraphicsContext gc);
}
