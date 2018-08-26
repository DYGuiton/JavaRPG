package DataManagement;

import java.util.ArrayList;
import CharacterComponents.JobMain;
import CharacterComponents.JobSub;
import java.io.Serializable;

/** @author Yurichi*/
public class JobSubList extends ArrayList<JobSub> implements Serializable{

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (JobSub nextJob: this) {
            sb.append(nextJob.toString() + "\n");
        }

        return sb.toString();
    }
}
