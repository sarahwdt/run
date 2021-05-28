package game.core.objects;

import game.core.objects.abstractions.PlayerControlled;
import javafx.scene.paint.Color;

public class Actor extends Circle implements PlayerControlled {
    public Actor(double x, double y, Color color, double r) {
        super(x, y, color, r);
    }
}
