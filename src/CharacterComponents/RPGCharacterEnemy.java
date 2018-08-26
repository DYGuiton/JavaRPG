package CharacterComponents;

import java.util.ArrayList;

/**
 * @author Yurichi
 */
public class RPGCharacterEnemy extends RPGCharacter {

    public RPGCharacterEnemy(ProfileEnemy nuProfile, JobMainEnemy nuMainJob, SubJobContainer nuSubJobs) {
        super(nuProfile, nuMainJob, nuSubJobs);
    }

    //deep copy constructor
    public RPGCharacterEnemy(RPGCharacterEnemy copyCharacter) {
        deepCopyCharacter(copyCharacter);
    }

    private void deepCopyCharacter(RPGCharacterEnemy copyCharacter) {
        myProfile = new ProfileEnemy((ProfileEnemy) copyCharacter.getProfile());
        myMainJob = new JobMainEnemy((JobMainEnemy) copyCharacter.getMainJob());
        mySubJobContainer = new EnemySubJobContainer((EnemySubJobContainer)copyCharacter.getSubJobs());
    }
}
