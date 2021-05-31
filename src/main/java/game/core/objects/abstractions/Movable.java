package game.core.objects.abstractions;

import game.core.behavior.move.Move;

import java.util.List;

/**
 * Интерфейс определяющий передвигаемые объекты
 */
public interface Movable {

    /**
     * @return список компонент поведения - движений
     */
    List<Move> getMoves();

    /**
     * Задание новых компонентов поведения - движения
     * @param moves список компонент
     */
    void setMoves(List<Move> moves);
}
