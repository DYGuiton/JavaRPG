package DataManagement;

import java.util.HashMap;
import CharacterComponents.JobMain;
import CharacterComponents.JobSub;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class JobSubMap implements Serializable{

    int size;

    HashMap<Integer, JobSub> idMap;
    HashMap<String, JobSub> nameMap;

    public JobSubMap() {
        idMap = new HashMap<>();
        nameMap = new HashMap<>();
        size = 0;
    }

    public void put(JobSub nuJob) {
        idMap.put(nuJob.getId(), nuJob);
        nameMap.put(nuJob.getName(), nuJob);
        size++;
    }

    public JobSub getByID(int id) {
        return idMap.get(id);
    }

    public JobSub getByName(String name) {
        return nameMap.get(name);
    }

    public JobSub removeByID(int id) {
        return nameMap.remove(idMap.remove(id).getName());
    }

    public JobSub removeByName(String name) {
        return idMap.remove(nameMap.remove(name).getId());
    }

    public boolean isEmpty() {
        return idMap.isEmpty() && nameMap.isEmpty();
    }
}
