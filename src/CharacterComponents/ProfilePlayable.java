package CharacterComponents;

import java.util.ArrayList;

/**
 * @author Yurichi
 */
public class ProfilePlayable extends Profile {

    public ProfilePlayable() {

    }

    public ProfilePlayable(String name, int id, int gender, int startingJobId, 
            ProfileStats newProfileStats, ArrayList<Integer> nuSubJobIds) {
        super(name, id, gender, startingJobId, newProfileStats, nuSubJobIds);
    }

    //deep copy constructor
    public ProfilePlayable(ProfilePlayable copyProfile) {
        super(copyProfile);
    }

    public String getJobToString(int jobID) {
        switch (jobID) {
            case 0:
                return "Warrior";
            case 1:
                return "Mage";
            case 2:
                return "Ranger";
            default:
                return "Warrior";
        }
    }

}
