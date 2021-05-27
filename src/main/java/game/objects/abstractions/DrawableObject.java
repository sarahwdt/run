package game.objects.abstractions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public abstract class DrawableObject extends BasicObject implements Drawable{
    protected Color color;

    public DrawableObject(double x, double y, Color color) {
        super(x, y);
        this.color = color;
    }

    public DrawableObject(DrawableObject object){
        super(object);
        color = new Color(object.color.getRed(),
                object.color.getGreen(),
                object.color.getBlue(),
                object.color.getOpacity());
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public abstract void draw(GraphicsContext gc);
}
