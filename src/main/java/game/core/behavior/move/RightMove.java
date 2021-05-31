package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

/**
 * Движение вправо
 */
public class RightMove implements Move {
    private boolean active = false;
    private double velocity = 0;
    private double g = 0.1;
    private final double rightBound;

    /**
     * Инициализация движения
     *
     * @param rightBound правая граница движения
     */
    public RightMove(double rightBound) {
        this.rightBound = rightBound;
    }

    /**
     * Передвижение объекта
     *
     * @param target объект
     */
    @Override
    public void move(BasicObject target) {
        if (!active) return;
        if (velocity <= 0) {
            velocity = 0;
            deactivate();
        }
        double x = target.getX() + velocity;
        if (x < rightBound) {
            target.setX(x);
            velocity -= g;
        } else {
            velocity = 0;
            deactivate();
        }
    }

    /**
     * Начало движения с постоянной скоростью
     *
     * @param velocity скорость
     */
    public void begin(double velocity) {
        activate();
        this.velocity = velocity;
        g = 0;
    }

    /**
     * Остановка движения с замедлением
     */
    public void stop() {
        g = 0.1;
    }

    /**
     * @return активен ли объект
     */
    @Override
    public boolean isActive() {
        return active;
    }

    /**
     * Активация движения
     */
    @Override
    public void activate() {
        active = true;
    }

    /**
     * Деактивация движения
     */
    @Override
    public void deactivate() {
        active = false;
    }

    /**
     * Установка стартовых значений для движения
     */
    @Override
    public void reset() {
        active = false;
        velocity = 0;
    }
}
