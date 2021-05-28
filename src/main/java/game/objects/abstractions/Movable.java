package game.objects.abstractions;

import game.objects.behavior.move.Move;

import java.util.List;

public interface Movable {

    List<Move> getMoves();

    void setMoves(List<Move> moves);
}
