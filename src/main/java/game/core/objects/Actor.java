package game.core.objects;

import game.core.objects.abstractions.PlayerControlled;
import javafx.scene.paint.Color;

/**
 * Объект, управляемого игроком - круг
 */
public class Actor extends Circle implements PlayerControlled {
    /**
     * Инициализация объекта
     * @param x координата по горизонтали слева
     * @param y координата по вертикали сверху
     * @param color цвет
     * @param r радиус
     */
    public Actor(double x, double y, Color color, double r) {
        super(x, y, color, r);
    }
}
