package controllers;

import game.config.EasyGameConfig;
import game.config.HardGameConfig;
import game.core.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class GameFormHardController extends BasicController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Label scoreLabel;

    private GameEngine engine;

    public void restart() {
        engine.restart();
    }

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

    public void onKeyPressed(KeyEvent keyEvent) {
        engine.input(keyEvent);
    }

}
