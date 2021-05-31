package controllers;

import game.config.EasyGameConfig;
import game.core.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер окна игры
 */
public class GameFormController extends BasicController implements Initializable {
    /**
     * Холст
     */
    @FXML
    private Canvas canvas;
    /**
     * Строка счета
     */
    @FXML
    private Label scoreLabel;

    /**
     * Движок игры
     */
    private GameEngine engine;

    /**
     * Обработка события нажатия на кнопку мышью
     * Рестарт игры
     */
    public void restart() {
        engine.restart();
        scenes.get("easy").setOnKeyPressed(this::onKeyPressed);
        scenes.get("easy").setOnKeyReleased(this::onKeyPressed);
    }

    /**
     * Обработка события нажатия на кнопку мышью
     * Переход в меню
     */
    public void menu() {
        engine.stop();
        stage.setScene(scenes.get("main"));
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = new GameEngine(new EasyGameConfig(canvas));
        engine.setScoreLabel(scoreLabel);
        engine.stop();
    }

    /**
     * Обработчик события нажатия на кнопку
     *
     * @param keyEvent событие
     */
    @FXML
    public void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
        System.out.println(keyEvent);
        engine.input(keyEvent);
    }

}
