package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

public class RunImitationMove implements Move {
    private boolean active = false;
    private double speed;
    private double defaultSpeed;
    private final double maxSpeed;
    private final double speedIncrease;

    public RunImitationMove(double startSpeed, double speedIncrease, double maxSpeed) {
        this.speed = startSpeed;
        this.defaultSpeed = startSpeed;
        this.speedIncrease = speedIncrease;
        this.maxSpeed = maxSpeed;
    }

    @Override
    public void move(BasicObject target) {
        target.setX(target.getX() - speed);
        if (speed < maxSpeed) speedIncrease();
    }

    protected void speedIncrease() {
        speed += speedIncrease;
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

    @Override
    public void reset() {
        speed = defaultSpeed;
    }
}
