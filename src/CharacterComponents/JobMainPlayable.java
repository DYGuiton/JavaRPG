package CharacterComponents;

/**
 * @author Yurichi
 */
public class JobMainPlayable extends JobMain {

    public JobMainPlayable() {

    }

    //database constructor
    public JobMainPlayable(String jobName, int jobId, JobMainStats newJobStats) {
        super(jobName, jobId, newJobStats);
    }

    //deep copy constructor
    public JobMainPlayable(JobMainPlayable copyJob) {
        super(copyJob);
    }

}
