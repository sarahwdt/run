package game.config;

import game.core.objects.Actor;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;

import java.util.List;
import java.util.Set;

public interface GameConfig {
    List<BasicObject> getAvailableBarriers();
    List<BasicObject> getLocationObjects();
    Actor getActor();
    double getSpawnRange();
    Canvas getCanvas();
    int getBarriersCount();
}
