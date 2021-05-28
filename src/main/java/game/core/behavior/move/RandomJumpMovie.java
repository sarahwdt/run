package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

import static java.lang.Math.random;

public class RandomJumpMovie extends JumpMove {
    public RandomJumpMovie() {
        super(1);
    }

    @Override
    public void move(BasicObject target) {
        if (100 * random() < 3) jumpOnFloor(2);
        super.move(target);
    }
}
