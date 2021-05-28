package game.core.service;

import game.config.GameConfig;
import game.core.objects.abstractions.BasicObject;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ObjectHub {
    public List<BasicObject> getObjects() {
        return objects;
    }

    private final List<BasicObject> objects = new LinkedList<>();
    private Set<BasicObject> barricades = new HashSet<>();

    public void reset(GameConfig gameConfig){
        barricades = gameConfig.getAvailableBarriers();
        objects.clear();
        objects.add(gameConfig.getActor());
        objects.addAll(gameConfig.getLocationObjects());
    }

    public Set<BasicObject> getAvailableBarriers() {
        return barricades;
    }

    public void setAvailableBarriers(Set<BasicObject> barricades) {
        this.barricades = barricades;
    }
}
