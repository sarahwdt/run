package game.objects.behavior.move;

import game.objects.abstractions.BasicObject;

public class JumpMove implements Move {
    private double velocity;
    private double g = 0.1;
    private int maxJumps = 3;
    private double maxY;
    private int jumpsCount = 0;
    private boolean active = false;

    public JumpMove(int maxJumps, double maxY) {
        this.maxJumps = maxJumps;
        this.maxY = maxY;
    }

    @Override
    public void move(BasicObject target) {
        if (!active) return;


        double y = target.getY() - velocity;
        System.out.println(y);
        System.out.println(target.getDefaultY());
        if (y < 50) {
            velocity = 0;
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

    public int getMaxJumps() {
        return maxJumps;
    }

    public void setMaxJumps(int maxJumps) {
        this.maxJumps = maxJumps;
    }
}
