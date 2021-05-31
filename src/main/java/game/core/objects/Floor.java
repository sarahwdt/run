package game.core.objects;

import game.core.objects.abstractions.SimpleFigureObject;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Объект пола - прямоугольник
 */
public class Floor extends SimpleFigureObject {
    private double a, b;

    /**
     * Инициализация объекта
     *
     * @param x     координата по горизонтали слева
     * @param y     координата по вертикали сверху
     * @param color цвет
     * @param a     ширина
     * @param b     высота
     */
    public Floor(double x, double y, Color color, double a, double b) {
        super(x, y, color);
        this.a = a;
        this.b = b;
    }

    /**
     * Метод отрисовки
     *
     * @param gc графический контекст("крандаш")
     */
    @Override
    public void draw(GraphicsContext gc) {
        gc.setFill(this.color);
        gc.fillRect(getX(), getY(), a, b);
    }
}
