package game.core.objects;

import game.core.behavior.move.Move;
import game.core.objects.abstractions.Collided;
import game.core.objects.abstractions.Drawable;
import game.core.objects.abstractions.Movable;
import game.core.objects.abstractions.SimpleFigureObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Shape;

import java.util.LinkedList;
import java.util.List;

/**
 * Объект препятствия - двигаемый, отрисовываемый, сталкиваемый круг
 */
public class Circle extends SimpleFigureObject implements Movable, Drawable, Collided {
    protected double r;
    protected List<Move> moves = new LinkedList<>();

    /**
     * Инициализация
     *
     * @param x     координата по горизонтали слева
     * @param y     координата по вертикали сверху
     * @param color цвет
     * @param r     радиус
     */
    public Circle(double x, double y, Color color, double r) {
        super(x, y, color);
        this.r = r;
    }

    /**
     * Конструктор копирования
     *
     * @param circle копируемый объект
     */
    public Circle(Circle circle) {
        super(circle);
        this.r = circle.r;
        this.moves = circle.moves;
    }

    /**
     * Метод отрисовки
     *
     * @param gc графический контекст("крандаш")
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillOval(getX() - r, getY() - r, r, r);
    }

    /**
     * @return список поддерживаемого поведения-движения объекта
     */
    @Override
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * Установка списка поддерживаемого поведения-движения объекта
     *
     * @param moves список компонент
     */
    @Override
    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * @return физическая модель
     */
    @Override
    public Shape getShape() {
        return new Ellipse(getX() - r / 2, getY() - r / 2, r / 2 - 5, r / 2 - 5);
    }

    /**
     * Установка стартовых значений для объекта(координаты при создании)
     */
    @Override
    public void reset() {
        super.reset();
        moves.forEach(Move::reset);
    }
}
