package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

/**
 * Имитация движения игрока (но движуться все сотальные объекты)
 * Движение объекта влево с постоянным увеличением скорости
 */
public class RunImitationMove implements Move {
    private boolean active = false;
    private double speed;
    private double defaultSpeed;
    private final double maxSpeed;
    private final double speedIncrease;

    /**
     * Инициализация движения
     *
     * @param startSpeed    стартовая скорость (пикселей/цикл)
     * @param speedIncrease увеличение скорости за цикл (пикселей/цикл)
     * @param maxSpeed      мксимальная скорость (пикселей/цикл)
     */
    public RunImitationMove(double startSpeed, double speedIncrease, double maxSpeed) {
        this.speed = startSpeed;
        this.defaultSpeed = startSpeed;
        this.speedIncrease = speedIncrease;
        this.maxSpeed = maxSpeed;
    }

    /**
     * Передвижение объекта
     *
     * @param target объект
     */
    @Override
    public void move(BasicObject target) {
        target.setX(target.getX() - speed);
        if (speed < maxSpeed) speedIncrease();
    }

    /**
     * Функция увеличения скорости за цикл
     */
    protected void speedIncrease() {
        speed += speedIncrease;
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
        speed = defaultSpeed;
    }
}
