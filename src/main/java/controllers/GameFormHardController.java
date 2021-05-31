package controllers;

import game.config.HardGameConfig;
import game.core.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * Контроллер окна игры повыщенной сложности
 */
public class GameFormHardController extends BasicController implements Initializable {
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
        scenes.get("hard").setOnKeyPressed(this::onKeyPressed);
        scenes.get("hard").setOnKeyReleased(this::onKeyPressed);
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
        engine = new GameEngine(new HardGameConfig(canvas));
        engine.setScoreLabel(scoreLabel);
        engine.stop();
    }

    /**
     * Обработка события нажатия на клавишу
     *
     * @param keyEvent событие
     */
    public void onKeyPressed(KeyEvent keyEvent) {
        engine.input(keyEvent);
    }

}
