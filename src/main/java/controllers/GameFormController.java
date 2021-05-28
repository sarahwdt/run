package controllers;

import game.config.EasyGameConfig;
import game.core.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.*;

public class GameFormController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Button menuButton;
    @FXML
    private Label scoreLabel;

    private GameEngine engine;

    public void onMouseClicked() {
        engine.restart();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = new GameEngine(new EasyGameConfig(canvas));
        engine.setScoreLabel(scoreLabel);
/*        initObjects();
        engine.schedule(drawEngine, 0, 16);
        engine.schedule(moveEngine, 0, 16);
        engine.schedule(respawnEngine, 0, 16);
        engine.schedule(scoreEngine, 1000, 1000);*/

        //TODO логика
    }

    public void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
        engine.input(keyEvent);
    }

}
