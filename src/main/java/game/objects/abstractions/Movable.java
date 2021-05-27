package game.objects.abstractions;

import javafx.scene.paint.Color;
import game.objects.behavior.move.Move;

import java.util.LinkedList;
import java.util.List;

public abstract class Movable extends DrawableObject {
    protected List<Move> moveChain = new LinkedList<>();

    public Movable(double x, double y, Color color) {
        super(x, y, color);
    }

    public Movable(Movable movable) {
        super(movable);
        moveChain = new LinkedList<>(movable.moveChain);
    }

    public List<Move> getMoveBehavior() {
        return moveChain;
    }

    public void setMoveBehavior(List<Move> moveChain) {
        this.moveChain = moveChain;
    }

}
