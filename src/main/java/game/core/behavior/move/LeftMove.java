package game.core.behavior.move;

import game.core.objects.abstractions.BasicObject;

public class LeftMove implements Move {
    private boolean active = false;
    private double velocity = 0;
    private double g = 0.1;
    private final double leftBound;

    public LeftMove(double leftBound) {
        this.leftBound = leftBound;
    }

    @Override
    public void move(BasicObject target) {
        if(!active) return;
        if(velocity <= 0){
            velocity = 0;
            deactivate();
        }
        double x = target.getX() - velocity;
        if(x > leftBound){
            target.setX(x);
            velocity -= g;
        }else {
            velocity = 0;
            deactivate();
        }
    }

    public void begin(double velocity){
        activate();
        this.velocity = velocity;
        g = 0;
    }

    public void stop(){
        g = 0.1;
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
        active = false;
        velocity = 0;
    }
}
