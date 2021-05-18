package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.abstractions.XYObject;

public class Floor extends XYObject {
    private double a, b;

    public Floor(double x, double y, Color color, double a, double b) {
        super(x, y, color);
        this.a = a;
        this.b = b;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(x, y, a, b);
    }
}