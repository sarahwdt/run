package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

/**
 * Движение - прыжок
 */
public class JumpMove implements Move {
    private double velocity;
    private double g = 0.5;
    private int maxJumps = 3;
    private int jumpsCount = 0;
    private boolean active = false;

    /**
     * Конструктор объекта движения
     *
     * @param maxJumps максимальное количество прыжков(0 - без ограничений)
     */
    public JumpMove(int maxJumps) {
        this.maxJumps = maxJumps;
    }

    /**
     * Передвижение объекта
     *
     * @param target объект
     */
    @Override
    public void move(BasicObject target) {
        if (!active) return;


        double y = target.getY() - velocity;
        if (y < 50) {
            velocity = -1;
            jumpsCount = maxJumps;
        } else if (y < target.getDefaultY()) {
            target.setY(y);
            velocity -= g;
        } else {
            target.setY(target.getDefaultY());
            velocity = 0;
            jumpsCount = 0;
            deactivate();
        }
    }

    /**
     * @return активен ли объект
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Активация движения
     */
    public void activate() {
        active = true;
    }

    /**
     * Прыжок с места
     *
     * @param velocity начальная скорость(пикселей/цикл)
     */
    public void jumpOnFloor(double velocity) {
        activate();
        if (jumpsCount < maxJumps || maxJumps == 0) {
            this.velocity = velocity;
            this.jumpsCount += 1;
        }
    }

    /**
     * Прыжок в воздухе
     *
     * @param velocity начальная скорость(пикселей/цикл)
     */
    public void jumpOnAir(double velocity) {
        activate();
        if (jumpsCount < maxJumps || maxJumps == 0) {
            this.velocity += velocity;
            this.jumpsCount += 1;
        }
    }

    /**
     * Деактивация движения
     */
    public void deactivate() {
        active = false;
    }

    /**
     * Установка стартовых значений для движения
     */
    @Override
    public void reset() {
        jumpsCount = 0;
        velocity = 0;
    }

    /**
     * @return максимальное количество прыжков
     */
    public int getMaxJumps() {
        return maxJumps;
    }

    /**
     * Установка максимального количества прыжков
     *
     * @param maxJumps количество прыжков
     */
    public void setMaxJumps(int maxJumps) {
        this.maxJumps = maxJumps;
    }
}
