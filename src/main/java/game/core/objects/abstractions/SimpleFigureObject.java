package game.core.objects.abstractions;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Абстракция простой фигуры
 */
public abstract class SimpleFigureObject extends BasicObject implements Drawable{
    protected Color color;

    /**
     * Инициализация фигуры
     * @param x координата по горизонтали слева
     * @param y координата по вертикали справа
     * @param color цвет
     */
    public SimpleFigureObject(double x, double y, Color color) {
        super(x, y);
        this.color = color;
    }

    /**
     * Копирующий конструктор
     * @param object копируемый объект
     */
    public SimpleFigureObject(SimpleFigureObject object){
        super(object);
        color = new Color(object.color.getRed(),
                object.color.getGreen(),
                object.color.getBlue(),
                object.color.getOpacity());
    }

    /**
     * @return цвет
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
     * Метод отрисовки объекта
     * @param gc графический контекст("крандаш")
     */
    public abstract void draw(GraphicsContext gc);

    /**
     * Метод масштабирования объекта
     * @param ration множитель
     */
    @Override
    public void scale(double ration) {

    }


}
