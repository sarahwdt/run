package game.core.objects.abstractions;

/**
 * Абстракция базового объекта
 */
public abstract class BasicObject {
    private double x,y;
    private final double defaultX;
    private final double defaultY;

    /**
     * Инициализация объекта
     * @param x координата по горизонтали от левого края
     * @param y координата по вертикали сверху
     */
    public BasicObject(double x, double y) {
        this.x = x;
        this.y = y;
        this.defaultX = x;
        this.defaultY = y;
    }

    /**
     * Конструктор копирования
     * @param object объект для копирования
     */
    public BasicObject(BasicObject object) {
        this.x = object.x;
        this.y = object.y;
        this.defaultX = object.x;
        this.defaultY = object.y;
    }

    /**
     * @return координата по горизонтали слева
     */
    public double getX() {
        return x;
    }

    /**
     * Установка координаты по горизонтали слева
     * @param x координата
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * @return координата по вертикали сверху
     */
    public double getY() {
        return y;
    }
    /**
     * Установка координаты по вертикали сверху
     * @param y координата
     */
    public void setY(double y) {
        this.y = y;
    }

    /**
     * @return координата по горизонтали при создании
     */
    public double getDefaultX() {
        return defaultX;
    }

    /**
     * @return координата сверху при создании
     */
    public double getDefaultY() {
        return defaultY;
    }

    /**
     * Установка стартовых значений для объекта(координаты при создании)
     */
    public void reset(){
        x = defaultX;
        y = defaultY;
    }

    /**
     * Пропоцианальное увеличение объекта
     * @param ration множитель
     */
    public abstract void scale(double ration);
}
