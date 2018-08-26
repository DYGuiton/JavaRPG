package DataManagement;

import java.util.HashMap;
import CharacterComponents.JobMain;
import CharacterComponents.RPGCharacter;
import java.io.Serializable;

/**
 * @author Yurichi
 */
class JobMainMap implements Serializable{

    int size;

    HashMap<Integer, JobMain> idMap;
    HashMap<String, JobMain> nameMap;

    public JobMainMap() {
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        size = 0;
    }

    public void put(JobMain nuJob) {
        idMap.put(nuJob.getId(), nuJob);
        nameMap.put(nuJob.getName(), nuJob);
        size++;
    }

    public JobMain getByID(int id) {
        return idMap.get(id);
    }

    public JobMain getByName(String name) {
        return nameMap.get(name);
    }

    public JobMain removeByID(int id) {
        return nameMap.remove(idMap.remove(id).getName());
    }

    public JobMain removeByName(String name) {
        return idMap.remove(nameMap.remove(name).getId());
    }

    public boolean isEmpty() {
        return idMap.isEmpty() && nameMap.isEmpty();
    }
}
