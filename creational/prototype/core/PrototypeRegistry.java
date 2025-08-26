package core;

import model.GameObject;
import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private final Map<String, GameObject> prototypes = new HashMap<>();

    public void addPrototype(String key, GameObject prototype) {
        prototypes.put(key.toLowerCase(), prototype);
    }

    public GameObject getClone(String key) {
        GameObject masterCopy = prototypes.get(key.toLowerCase());
        if (masterCopy != null) {
            return masterCopy.clone();
        }
        return null; 
    }
}