package CharacterComponents;

/**
 * @author Yurichi
 */
public class JobMainEnemy extends JobMain {

    public JobMainEnemy() {

    }

    //database constructor
    public JobMainEnemy(String jobName, int jobId, JobMainStats newJobStats) {
        super(jobName, jobId, newJobStats);
    }

    //deep copy constructor
    public JobMainEnemy(JobMainEnemy copyJob) {
        super(copyJob);
    }

}
