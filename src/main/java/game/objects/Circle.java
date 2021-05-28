package game.objects;

import game.objects.abstractions.*;
import game.objects.behavior.move.Move;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

import java.util.LinkedList;
import java.util.List;

public class Circle extends SimpleFigureObject implements Controlable, Movable, Drawable, Collided {
    protected double r;
    protected List<Move> moves = new LinkedList<>();

    public Circle(double x, double y, Color color, double r) {
        super(x, y, color);
        this.r = r;
    }

    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(getX() - r, getY() - r, r, r);
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
        return new Ellipse(getX() - r / 2, getY() - r / 2, r / 2 - 10, r / 2 - 10);
    }

    @Override
    public void reset() {
        super.reset();
        moves = new LinkedList<>();
    }
}
