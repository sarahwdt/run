package game.objects;

import game.objects.abstractions.Controlable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import game.objects.abstractions.Movable;

public class Circle extends Movable implements Controlable {
    protected double r;

    public Circle(double x, double y, Color color, double r) {
        super(x, y, color);
        this.r = r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(getX() - r, getY() - r, r, r);
    }
}
