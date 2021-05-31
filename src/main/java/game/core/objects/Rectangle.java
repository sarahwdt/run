package game.core.objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;

/**
 * Объект препятствия - переиспользуемый, двигаемый, отрисовываемый, сталкиваемый прямоугольник
 */
public class Rectangle extends Cube {
    private double b;

    /**
     * Инициализация объекта
     *
     * @param x     координата по горизонтали слева
     * @param y     координата по вертикали сверху
     * @param color цвет
     * @param a     длинна
     * @param b     высота
     */
    public Rectangle(double x, double y, Color color, double a, double b) {
        super(x, y, color, a);
        this.b = b;
    }

    /**
     * Конструктор копирования
     *
     * @param rectangle копируемый объект
     */
    public Rectangle(Rectangle rectangle) {
        super(rectangle);
        this.b = rectangle.b;
        moves = rectangle.moves;
    }

    /**
     * Метод отрисовки
     *
     * @param gc графический контекст("крандаш")
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(getX(), getY() - b, a, b);
    }

    /**
     * @return физическая модель
     */
    @Override
    public Shape getShape() {
        return new javafx.scene.shape.Rectangle(getX(), getY() - b, a, b);
    }
}
