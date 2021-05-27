package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;

public class CubeMove implements Move {
    @Override
    public void move(BasicObject target) {
        target.setX(target.getX() - 2);
    }
}
