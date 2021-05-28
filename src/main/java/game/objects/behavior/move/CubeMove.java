package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;

public class CubeMove implements Move {
    private boolean active = false;
    @Override
    public void move(BasicObject target) {
        target.setX(target.getX() - 2);
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void activate() {
        active = true;
    }

    @Override
    public void deactivate() {
        active = false;
    }
}
