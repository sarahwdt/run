package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.abstractions.Movable;
import objects.abstractions.XYObject;

public class Circle extends XYObject implements Movable {
    protected double r;

    public Circle(double x, double y, Color color, double r) {
        super(x, y, color);
        this.r = r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(x - r, y - r, r, r);
    }

    @Override
    public void move(double xOff, double yOff) {
        this.x = x + xOff;
        this.y = y + yOff;
    }
}
