package game.config;

import game.core.objects.Actor;
import game.core.objects.abstractions.BasicObject;
import javafx.scene.canvas.Canvas;

import java.util.List;
import java.util.Set;

public interface GameConfig {
    Set<BasicObject> getAvailableBarriers();
    List<BasicObject> getLocationObjects();
    Actor getActor();
    int getBarrierCount();
    double getSpawnRange();
    Canvas getCanvas();
}
