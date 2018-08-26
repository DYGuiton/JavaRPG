package CharacterComponents;

import java.util.ArrayList;

/**
 * @author Yurichi
 */
public class RPGCharacterPlayable extends RPGCharacter {
    
    boolean isMainCharacter;

    public RPGCharacterPlayable(ProfilePlayable nuProfile, JobMainPlayable nuJobMain, SubJobContainer nuSubJobs, boolean isMain) {
        super(nuProfile, nuJobMain, nuSubJobs);
        isMainCharacter = isMain;
    }

    //deep copy constructor
    public RPGCharacterPlayable(RPGCharacterPlayable copyCharacter) {
        deepCopyCharacter(copyCharacter);
    }

    private void deepCopyCharacter(RPGCharacterPlayable copyCharacter) {

        myProfile = new ProfilePlayable((ProfilePlayable) copyCharacter.getProfile());
        myMainJob = new JobMainPlayable((JobMainPlayable) copyCharacter.getMainJob());
        mySubJobContainer = new PlayableSubJobContainer((PlayableSubJobContainer)copyCharacter.getSubJobs()); 
    }

}
