package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

import static java.lang.Math.random;

/**
 * Случайно запускаемый прыжок
 */
public class RandomJumpMovie extends JumpMove {
    public RandomJumpMovie() {
        super(3);
    }
    /**
     * Передвижение объекта
     *
     * @param target объект
     */
    @Override
    public void move(BasicObject target) {
        if (100 * random() < 1) jumpOnFloor(6);
        super.move(target);
    }
}
