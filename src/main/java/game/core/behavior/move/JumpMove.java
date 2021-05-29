package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

public class JumpMove implements Move {
    private double velocity;
    private double g = 0.5;
    private int maxJumps = 3;
    private int jumpsCount = 0;
    private boolean active = false;

    public JumpMove(int maxJumps) {
        this.maxJumps = maxJumps;
    }

    @Override
    public void move(BasicObject target) {
        if (!active) return;


        double y = target.getY() - velocity;
        if (y < 50) {
            velocity = -1;
            jumpsCount = maxJumps;
        } else if (y < target.getDefaultY()) {
            target.setY(y);
            velocity -= g;
        } else {
            target.setY(target.getDefaultY());
            velocity = 0;
            jumpsCount = 0;
            deactivate();
        }
    }

    public boolean isActive() {
        return active;
    }

    public void activate() {
        active = true;
    }

    public void jumpOnFloor(double velocity) {
        activate();
        if (jumpsCount < maxJumps || maxJumps == 0) {
            this.velocity = velocity;
            this.jumpsCount += 1;
        }
    }

    public void jumpOnAir(double velocity) {
        activate();
        if (jumpsCount < maxJumps || maxJumps == 0) {
            this.velocity += velocity;
            this.jumpsCount += 1;
        }
    }

    public void deactivate() {
        active = false;
    }

    @Override
    public void reset() {
        jumpsCount = 0;
        velocity = 0;
    }

    public int getMaxJumps() {
        return maxJumps;
    }

    public void setMaxJumps(int maxJumps) {
        this.maxJumps = maxJumps;
    }
}
