package CharacterComponents;

import java.util.ArrayList;

/**
 * @author Yurichi
 */
public class ProfileEnemy extends Profile {

    public ProfileEnemy() {

    }

    public ProfileEnemy(String name, int id, int gender, int startingJobId, 
            ProfileStats newProfileStats, ArrayList<Integer> nuSubJobIds) {
        super(name, id, gender, startingJobId, newProfileStats, nuSubJobIds);
    }

    //deep copy constructor
    public ProfileEnemy(ProfileEnemy copyProfile) {
        super(copyProfile);
    }

    public String getJobToString(int jobID) {
        switch (jobID) {
            case 0:
                return "Animal";
            default:
                return "Animal";
        }
    }

}
