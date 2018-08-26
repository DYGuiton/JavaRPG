package CharacterComponents;

import java.util.ArrayList;
import java.util.HashMap;
import DataManagement.JobSubData;

/**
 * @author Yurichi
 */
public class PlayableSubJobContainer extends SubJobContainer {

    public PlayableSubJobContainer(ArrayList<Integer> nuJobSubIds, JobSubData nuJobSubData) {
        super(nuJobSubIds, nuJobSubData);
    }

    public PlayableSubJobContainer(PlayableSubJobContainer copyContainer) {
        super(copyContainer);
    }

    public void addPlayableSubJob(int jobId) {
        JobSubPlayable nuSubJob = new JobSubPlayable((JobSubPlayable) theJobSubData.getJobPlayableById(jobId));
        subJobMap.put(jobId, nuSubJob);
    }

}
