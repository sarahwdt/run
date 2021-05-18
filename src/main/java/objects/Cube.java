package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.abstractions.Movable;
import objects.abstractions.XYObject;

public class Cube extends XYObject implements Movable {
    protected double a;

    public Cube(double x, double y, Color color, double a) {
        super(x, y, color);
        this.a = a;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(x, y, a, a);
    }

    @Override
    public void move(double xOff, double yOff) {
        this.x = x + xOff;
        this.y = y + yOff;
    }
}
