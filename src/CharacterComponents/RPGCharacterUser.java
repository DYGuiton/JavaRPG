package CharacterComponents;

/**
 * @author Yurichi
 */
public class RPGCharacterUser extends RPGCharacter {

    public RPGCharacterUser(ProfilePlayable nuProfile, JobMainPlayable nuJobMain, SubJobContainer nuSubJobs) {
        super(nuProfile, nuJobMain, nuSubJobs);
    }

    //deep copy constructor
    public RPGCharacterUser(RPGCharacterUser copyCharacter) {
        deepCopyCharacter(copyCharacter);
    }

    private void deepCopyCharacter(RPGCharacterUser copyCharacter) {

        myProfile = new ProfilePlayable((ProfilePlayable) copyCharacter.getProfile());
        myMainJob = new JobMainPlayable((JobMainPlayable) copyCharacter.getMainJob());
        mySubJobContainer = new PlayableSubJobContainer((PlayableSubJobContainer) copyCharacter.getSubJobs());
    }

}
