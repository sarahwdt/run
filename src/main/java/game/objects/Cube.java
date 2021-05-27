package game.objects;

import game.objects.abstractions.Reusable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import game.objects.abstractions.Movable;

public class Cube extends Movable implements Reusable {
    protected double a;

    public Cube(double x, double y, Color color, double a) {
        super(x, y, color);
        this.a = a;
    }

    public Cube(Cube cube) {
        super(cube);
        this.a = cube.a;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(getX(), getY(), a, a);
    }

    public double getA() {
        return a;
    }
}
