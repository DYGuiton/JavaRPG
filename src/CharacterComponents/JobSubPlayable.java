package CharacterComponents;

/**
 * @author Yurichi
 */
public class JobSubPlayable extends JobSub {

    public JobSubPlayable() {

    }

    //database constructor
    public JobSubPlayable(String jobName, int jobId) {
        super(jobName, jobId);
    }

    //deep copy constructor
    public JobSubPlayable(JobSubPlayable copyJob) {
        super(copyJob);
    }

}
