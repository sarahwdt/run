package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

/**
 * Интерфейс поведения(движения)
 */
public interface Move {
    /**
     * Передвижение объекта
     *
     * @param target объект
     */
    void move(BasicObject target);

    /**
     * @return активен ли объект
     */
    boolean isActive();

    /**
     * Активация движения
     */
    void activate();

    /**
     * Деактивация движения
     */
    void deactivate();

    /**
     * Установка стартовых значений для движения
     */
    void reset();
}
