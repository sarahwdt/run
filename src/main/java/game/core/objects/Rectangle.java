package game.core.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

public class Rectangle extends Cube {
    private double b;
    public Rectangle(double x, double y, Color color, double a, double b) {
        super(x, y, color, a);
        this.b = b;
    }

    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.b = rectangle.b;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(getX(), getY(), a, b);
    }

    @Override
    public Shape getShape() {
        return new javafx.scene.shape.Rectangle(getX(), getY(), a, b);
    }
}
