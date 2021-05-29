package game.core.objects;

import game.core.behavior.move.Move;
import game.core.objects.abstractions.Respawned;
import game.core.objects.abstractions.SimpleFigureObject;
import javafx.scene.paint.Color;

import java.util.List;

public class EnemyCircle extends Circle implements Respawned {
    public EnemyCircle(double x, double y, Color color, double r) {
        super(x, y, color, r);
    }

    public EnemyCircle(EnemyCircle enemyCircle) {
        super(enemyCircle);
    }
}
