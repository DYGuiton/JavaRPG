package DataManagement;

import java.util.ArrayList;
import CharacterComponents.JobMain;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class JobMainList extends ArrayList<JobMain> implements Serializable{

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (JobMain nextJob: this) {
            sb.append(nextJob.toString() + "\n");
        }

        return sb.toString();
    }

}
