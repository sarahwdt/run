package controllers;

import game.core.GameEngine;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import game.objects.Circle;
import game.objects.Cube;
import game.objects.Floor;
import game.objects.abstractions.Movable;
import game.objects.abstractions.DrawableObject;
import game.objects.behavior.move.CubeMove;
import game.objects.behavior.move.JumpMove;

import java.net.URL;
import java.util.*;

import static java.lang.Math.random;

public class GameFormController implements Initializable {
    @FXML
    private Canvas canvas;
    @FXML
    private Button menuButton;
    @FXML
    private Label scoreLabel;

    private GameEngine engine;
/*    private final Color floorColor = Color.TEAL;
    private final Color circleColor = Color.VIOLET;
    private final Color cubeColor = Color.RED;
    private List<DrawableObject> objectHub = new ArrayList<>();
    private int score = 0;

    private final Timer engine = new Timer();

    private final TimerTask moveEngine = new TimerTask() {
        @Override
        public void run() {
            objectHub.forEach(xyObject -> {
                if (xyObject instanceof Movable)
                    ((Movable) xyObject).getMoveBehavior().forEach(move -> move.move(xyObject));
            });
        }
    };

    private final TimerTask drawEngine = new TimerTask() {
        @Override
        public void run() {
            canvas.getGraphicsContext2D().clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
            objectHub.forEach(xyObject -> {
                xyObject.draw(canvas.getGraphicsContext2D());
            });
        }
    };

    private final TimerTask respawnEngine = new TimerTask() {
        @Override
        public void run() {
            objectHub.stream().filter(object -> object instanceof Cube && object.getX() + ((Cube) object).getA() < 0)
                    .forEach(object -> respawn(object, canvas.getWidth() + ((Cube) object).getA(), 300));
        }
    };

    private final TimerTask scoreEngine = new TimerTask() {
        @Override
        public void run() {
            score++;
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    scoreLabel.setText(String.valueOf(score));
                }
            });
        }
    };*/

    public void onMouseClicked(KeyEvent keyEvent) {
        engine.stop();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        engine = new GameEngine(canvas);
        engine.setScoreLabel(scoreLabel);
        engine.start();
/*        initObjects();
        engine.schedule(drawEngine, 0, 16);
        engine.schedule(moveEngine, 0, 16);
        engine.schedule(respawnEngine, 0, 16);
        engine.schedule(scoreEngine, 1000, 1000);*/

        //TODO логика
    }

/*    @FXML
    private void initObjects() {
        objectHub.add(new Floor(0, canvas.getHeight() - canvas.getHeight() * 0.1,
                floorColor, canvas.getWidth(), canvas.getHeight() * 0.1));
        Circle actor = new Circle(60, canvas.getHeight() - canvas.getHeight() * 0.1, circleColor, 50);
        actor.getMoveBehavior().add(new JumpMove(5));
        actor.getMoveBehavior().add(new JumpMove(6));
        objectHub.addAll(createEnemies());
        objectHub.add(actor);
    }*/

    public void onKeyPressed(javafx.scene.input.KeyEvent keyEvent) {
        engine.input(keyEvent);
    }

/*    private void respawn(DrawableObject object, double left, double range) {
        object.setX(left + (range * random()));
    }

    private List<Cube> createEnemies() {
        List<Cube> enemies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Cube enemy = new Cube(canvas.getWidth() - 50 + 300 * i, canvas.getHeight() - canvas.getHeight() * 0.1 - 50,
                    cubeColor, 50);
            enemy.getMoveBehavior().add(new CubeMove());
            enemies.add(enemy);
        }
        return enemies;
    }*/
}
