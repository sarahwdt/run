package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;
import game.objects.abstractions.DrawableObject;

public class JumpMove implements Move {
    private double velocity;
    private double defaultVelocity;
    private double g = 0.1;
    private boolean active = false;

    public JumpMove(int velocity) {
        this.defaultVelocity = velocity;
        this.velocity = velocity;
    }

    @Override
    public void move(BasicObject target) {
        if (!active) return;

        double y = target.getY() - velocity;
        if (y < target.getDefaultY()) {
            target.setY(y);
            velocity -= g;
        } else {
            target.setY(target.getDefaultY());
            this.active = false;
        }
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        velocity = defaultVelocity;
        active = true;
    }

    public void deactivate() {
        active = false;
    }
}
