package game.objects.abstractions;

public class BasicObject {
    private double x,y;
    private final double defaultX;
    private final double defaultY;

    public BasicObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.defaultX = x;
        this.defaultY = y;
    }

    public BasicObject(BasicObject object) {
        this.x = object.x;
        this.y = object.y;
        this.defaultX = object.x;
        this.defaultY = object.y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getDefaultX() {
        return defaultX;
    }

    public double getDefaultY() {
        return defaultY;
    }

    public void scale(double ration){

    }
}
