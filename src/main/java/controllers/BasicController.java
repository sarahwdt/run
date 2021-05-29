package controllers;

import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Map;

public class BasicController {
    protected Stage stage;
    protected Map<String, Scene> scenes;

    public void setScenes(Map<String, Scene> scenes) {
        this.scenes = scenes;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
