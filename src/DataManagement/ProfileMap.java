package DataManagement;

import java.util.HashMap;
import CharacterComponents.Profile;
import java.io.Serializable;

/**
 * @author Yurichi
 */
class ProfileMap implements Serializable{

    int size;

    HashMap<Integer, Profile> idMap;
    HashMap<String, Profile> nameMap;

    public ProfileMap() {
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        size = 0;
    }

    public void put(Profile nuProfile) {
        idMap.put(nuProfile.getId(), nuProfile);
        nameMap.put(nuProfile.getName(), nuProfile);
        size++;
    }

    public Profile getByID(int id) {
        return idMap.get(id);
    }

    public Profile getByName(String name) {
        return nameMap.get(name);
    }

    public Profile removeByID(int id) {
        return nameMap.remove(idMap.remove(id).getName());
    }

    public Profile removeByName(String name) {
        return idMap.remove(nameMap.remove(name).getId());
    }

    public boolean isEmpty() {
        return idMap.isEmpty() && nameMap.isEmpty();
    }
}
