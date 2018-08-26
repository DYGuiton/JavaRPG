package CharacterComponents;

/**
 * @author Yurichi
 */
public class JobSubEnemy extends JobSub {

    public JobSubEnemy() {

    }

    //database constructor
    public JobSubEnemy(String jobName, int jobId) {
        super(jobName, jobId);
    }

    //deep copy constructor
    public JobSubEnemy(JobSubEnemy copyJob) {
        super(copyJob);
    }
}
