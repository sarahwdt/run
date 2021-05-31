package game.core.objects;

import game.core.objects.abstractions.Respawned;
import javafx.scene.paint.Color;

/**
 * Объект препятствия - переиспользуемый, двигаемый, отрисовываемый, сталкиваемый куб
 */
public class EnemyCircle extends Circle implements Respawned {
    /**
     * Инициализация объекта
     *
     * @param x     координата по горизонтали слева
     * @param y     координата по вертикали сверху
     * @param color цвет
     * @param r     радиус
     */
    public EnemyCircle(double x, double y, Color color, double r) {
        super(x, y, color, r);
    }

    /**
     * Конструктор копирования
     *
     * @param enemyCircle копируемый объект
     */
    public EnemyCircle(EnemyCircle enemyCircle) {
        super(enemyCircle);
    }
}
