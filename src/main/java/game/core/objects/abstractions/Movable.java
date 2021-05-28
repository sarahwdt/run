package game.core.objects.abstractions;

import game.core.behavior.move.Move;

import java.util.List;

public interface Movable {

    List<Move> getMoves();

    void setMoves(List<Move> moves);
}
