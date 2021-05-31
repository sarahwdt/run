package game.core.objects;

import game.core.behavior.move.Move;
import game.core.objects.abstractions.*;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.LinkedList;
import java.util.List;

/**
 * Объект препятствия - переиспользуемый, двигаемый, отрисовываемый, сталкиваемый куб
 */
public class Cube extends SimpleFigureObject implements Respawned, Movable, Drawable, Collided {
    protected double a;
    protected List<Move> moves = new LinkedList<>();

    /**
     * Инициализация
     *
     * @param x     координата по горизонтали слева
     * @param y     координата по вертикали сверху
     * @param color цвет
     * @param a     сторона
     */
    public Cube(double x, double y, Color color, double a) {
        super(x, y, color);
        this.a = a;
    }

    /**
     * Конструктор копирования
     *
     * @param cube копируемый объект
     */
    public Cube(Cube cube) {
        super(cube);
        this.a = cube.a;
        moves = cube.moves;
    }

    /**
     * Метод отрисовки
     *
     * @param gc графический контекст("крандаш")
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(getX(), getY() - a, a, a);
    }

    /**
     * @return сторона куба
     */
    public double getA() {
        return a;
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
        return new Rectangle(getX(), getY() - a, a, a);
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
