package CharacterComponents;

import java.util.ArrayList;
import java.util.HashMap;
import DataManagement.JobSubData;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public abstract class SubJobContainer implements Serializable{

    public JobSub myCurrentSubJob;
    public JobSubData theJobSubData;

    public HashMap<Integer, JobSub> subJobMap;
    public JobSubList subJobList;

    public SubJobContainer() {
    }

    public SubJobContainer(ArrayList<Integer> nuJobSubIds, JobSubData nuJobSubData) {
        theJobSubData = nuJobSubData;
        subJobMap = new HashMap<>();
        subJobList = new JobSubList();

        for (int i = 0; i < nuJobSubIds.size(); i++) {
            JobSub nuSubJob = theJobSubData.getJobPlayableById(i);
            Integer nuSubJobId = nuJobSubIds.get(i);
            subJobMap.put(nuSubJobId, nuSubJob);
            subJobList.add(nuSubJob);
        }

        myCurrentSubJob = subJobMap.get(0);
    }
    
    public SubJobContainer(SubJobContainer copyContainer){
       //copy constructor
       this();
       theJobSubData = copyContainer.getSubJobData();
       subJobMap = new HashMap<>(copyContainer.getSubJobMap());
       subJobList = new JobSubList(copyContainer.getJobSubList());
       
       myCurrentSubJob = subJobMap.get(0);
       
    }

    public JobSub switchSubJob(int jobId) {
        return myCurrentSubJob = subJobMap.get(jobId);
    }

    public JobSub getSubJob(int jobId) {
        return subJobMap.get(jobId);
    }

    public JobSub getCurrentSubJob() {
        return myCurrentSubJob;
    }

    public JobSubList getJobSubList() {
        return subJobList;
    }

    public JobSubData getSubJobData() {
        return theJobSubData;
    }
    
    public HashMap<Integer, JobSub> getSubJobMap(){
        return subJobMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CURRENT SUBJOB:\n\t" + myCurrentSubJob.getName() + "\n");
        sb.append("LEARNED SUBJOBS:\n\t");
        for (JobSub jobSub : subJobList) {
            sb.append(jobSub.getName());
        }
        return sb.toString();

    }

}
