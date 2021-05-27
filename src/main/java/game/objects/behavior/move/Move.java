package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;
import game.objects.abstractions.DrawableObject;

public interface Move {
    void move(BasicObject target);
}
