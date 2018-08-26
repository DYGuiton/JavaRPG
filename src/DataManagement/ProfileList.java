package DataManagement;

import java.util.ArrayList;
import CharacterComponents.Profile;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class ProfileList extends ArrayList<Profile> implements Serializable{

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Profile nextProfile : this) {
            sb.append(nextProfile.toString() + "\n");
        }

        return sb.toString();
    }

}
