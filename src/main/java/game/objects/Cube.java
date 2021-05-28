package game.objects;

import game.objects.abstractions.*;
import game.objects.behavior.move.Move;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.LinkedList;
import java.util.List;

public class Cube extends SimpleFigureObject implements Reusable, Movable, Drawable, Collided {
    protected double a;
    protected List<Move> moves = new LinkedList<>();

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

    @Override
    public List<Move> getMoves() {
        return moves;
    }

    @Override
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public Shape getShape() {
        return new Rectangle(getX(), getY(), a, a);
    }

    @Override
    public void reset() {
        super.reset();
        moves = new LinkedList<>();
    }
}
