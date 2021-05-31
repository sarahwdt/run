package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Map;

/**
 * Базовый контроллер окна приложения
 */
public abstract class BasicController {
    protected Stage stage;
    protected Map<String, Scene> scenes;

    /**
     * Передача словаря сцен и их названий в контроллер
     *
     * @param scenes словарь "Название сцены, Сцена"
     */
    public void setScenes(Map<String, Scene> scenes) {
        this.scenes = scenes;
    }

    /**
     * Передача сцены для отображения
     *
     * @param stage сцена для отображения
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
