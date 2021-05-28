package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;

public interface Move {
    void move(BasicObject target);
    boolean isActive();
    void activate();
    void deactivate();
}
