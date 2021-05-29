import controllers.BasicController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Main extends Application {
    Map<String, Scene> scenes = new HashMap<>();
    Map<String, String> pages = Map.of("main", "forms/MainForm.fxml", "easy", "forms/GameForm.fxml", "hard", "forms/GameFormHard.fxml");
    List<BasicController> controllers = new LinkedList<>();

    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader;
        Parent parent;
        BasicController controller;
        for (String key: pages.keySet()){
            fxmlLoader = new FXMLLoader(getClass().getResource(pages.get(key)));
            parent = fxmlLoader.load();
            controllers.add(fxmlLoader.getController());
            scenes.put(key, new Scene(parent));
        }
        for (BasicController basicController : controllers) {
            basicController.setScenes(scenes);
            basicController.setStage(stage);
        }
        stage.setScene(scenes.get("main"));
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
