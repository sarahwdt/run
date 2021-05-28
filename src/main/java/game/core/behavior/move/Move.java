package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

public interface Move {
    void move(BasicObject target);
    boolean isActive();
    void activate();
    void deactivate();
    void reset();
}
