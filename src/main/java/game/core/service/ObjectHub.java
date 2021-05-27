package game.core.service;

import game.objects.abstractions.BasicObject;

import java.util.LinkedList;
import java.util.List;

public class ObjectHub {
    public List<BasicObject> getObjects() {
        return objects;
    }

    List<BasicObject> objects = new LinkedList<>();
}
