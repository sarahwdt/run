package objects.abstractions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class XYObject {
    protected double x, y;
    protected Color color;

    public XYObject(double x, double y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
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

    public abstract void draw(GraphicsContext gc);
}
