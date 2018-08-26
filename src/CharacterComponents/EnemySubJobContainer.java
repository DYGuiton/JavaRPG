package CharacterComponents;

import java.util.ArrayList;
import java.util.HashMap;
import DataManagement.JobSubData;

/**
 * @author Yurichi
 */
public class EnemySubJobContainer extends SubJobContainer {

    public EnemySubJobContainer(ArrayList<Integer> nuJobSubIds, JobSubData nuJobSubData) {
        super();
        theJobSubData = nuJobSubData;
        subJobMap = new HashMap<>();
        subJobList = new JobSubList();

        for (int i = 0; i < nuJobSubIds.size(); i++) {
            JobSub nuSubJob = theJobSubData.getJobEnemyById(i);
            Integer nuSubJobId = nuJobSubIds.get(i);
            subJobMap.put(nuSubJobId, nuSubJob);
            subJobList.add(nuSubJob);
        }

        myCurrentSubJob = subJobList.get(0);
    }

    public EnemySubJobContainer(EnemySubJobContainer copyContainer) {
        theJobSubData = copyContainer.getSubJobData();
        subJobMap = new HashMap<>();

        for (int i = 0; i < copyContainer.getJobSubList().size(); i++) {
            JobSubEnemy nuSubJob = new JobSubEnemy((JobSubEnemy) copyContainer.getJobSubList().get(i));
            Integer nuSubJobId = nuSubJob.getId();
            subJobMap.put(nuSubJobId, nuSubJob);
        }

        myCurrentSubJob = subJobList.get(0);
    }

    public void addEnemySubJob(int jobId) {
        JobSubEnemy nuSubJob = new JobSubEnemy((JobSubEnemy) theJobSubData.getJobEnemyById(jobId));
        subJobMap.put(jobId, nuSubJob);
    }

}
