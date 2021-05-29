package controllers;

import game.config.EasyGameConfig;
import game.core.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.*;

public class GameFormController extends BasicController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Label scoreLabel;
    @FXML
    private AnchorPane pane;

    private GameEngine engine;

    public void restart() {
        engine.restart();
        scenes.get("easy").setOnKeyPressed(this::onKeyPressed);
        scenes.get("easy").setOnKeyReleased(this::onKeyPressed);
    }

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

    @FXML
    public void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
        System.out.println(keyEvent);
        engine.input(keyEvent);
    }

}
