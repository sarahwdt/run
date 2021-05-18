package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import objects.Circle;
import objects.Cube;
import objects.Floor;
import objects.abstractions.XYObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class GameFormController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Button menuButton;
    private final Color floorColor = Color.TEAL;
    private final Color circleColor = Color.VIOLET;
    private final Color cubeColor = Color.RED;
    private List<XYObject> objectHub = new ArrayList<>();

    public void onMouseClicked() {

    }

    public void onKeyPressed() {
        System.out.println("key pressed");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initObjects();
        for(int i = 0; i < 15; i++){
            drawObjects(canvas.getGraphicsContext2D());
            moveCube();
        }
    }

    private void moveCube() {
        for (XYObject object : objectHub) {
            if(object instanceof Cube)
                ((Cube) object).move(-10, 0);
        }
    }

    private void drawObjects(GraphicsContext gc) {
        gc.clearRect(0,0, canvas.getWidth(), canvas.getHeight());
        for (XYObject object : objectHub) {
            object.draw(gc);
        }
    }

    @FXML
    private void initObjects() {
        objectHub.add(new Floor(0, canvas.getHeight() - canvas.getHeight() * 0.1,
                floorColor, canvas.getWidth(), canvas.getHeight() * 0.1));
        objectHub.add(new Circle(60, canvas.getHeight() - canvas.getHeight() * 0.1, circleColor, 50));
        objectHub.add(new Cube(canvas.getWidth() - 50, canvas.getHeight() - canvas.getHeight() * 0.1 - 50,
                cubeColor, 50));
    }
}
