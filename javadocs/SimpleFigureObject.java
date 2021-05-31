package game.core.objects.abstractions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Абстракция простой фигуры
 * Отрисовываемая
 */
public abstract class SimpleFigureObject extends BasicObject implements Drawable{
    protected Color color;

    /**
     * Инициализация
     * @param x координата по горизонтали слева
     * @param y координата по вертикали сверху
     * @param color цвет закраски
     */
    public SimpleFigureObject(double x, double y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * Конструктор копирования
     * @param object объект для копирования
     */
    public SimpleFigureObject(SimpleFigureObject object){
        super(object);
        color = new Color(object.color.getRed(),
                object.color.getGreen(),
                object.color.getBlue(),
                object.color.getOpacity());
    }

    /**
     * @return цвет объекта
     */
    public Color getColor() {
        return color;
    }

    /**
     * Установка цвета объекта
     * @param color цвет
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Реализация отрисовки
     * @param gc графический контекст("крандаш")
     */
    public abstract void draw(GraphicsContext gc);

    /**
     * Реализация масштабирования
     * @param ration множитель
     */
    @Override
    public void scale(double ration) {

    }


}
