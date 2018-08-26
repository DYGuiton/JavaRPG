package DataManagement;

import java.util.HashMap;
import CharacterComponents.RPGCharacter;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class CharacterMap implements Serializable{

    int size;

    HashMap<Integer, RPGCharacter> idMap;
    HashMap<String, RPGCharacter> nameMap;

    public CharacterMap() {
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        size = 0;
    }

    public void put(RPGCharacter nuCharacter) {
        
        idMap.put(nuCharacter.getId(), nuCharacter);
        nameMap.put(nuCharacter.getName(), nuCharacter);
        size++;
    }

    public RPGCharacter getByID(int id) {
        return idMap.get(id);
    }

    public RPGCharacter getByName(String name) {
        return nameMap.get(name);
    }

    public RPGCharacter removeByID(int id) {
        return nameMap.remove(idMap.remove(id).getName());
    }

    public RPGCharacter removeByName(String name) {
        return idMap.remove(nameMap.remove(name).getId());
    }

    public boolean isEmpty() {
        return idMap.isEmpty() && nameMap.isEmpty();
    }
}
