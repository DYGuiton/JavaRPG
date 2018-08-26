package DataManagement;

import java.util.ArrayList;
import CharacterComponents.RPGCharacter;
import java.io.Serializable;

/**
 *
 * @author Admin
 */
public class CharacterList extends ArrayList<RPGCharacter> implements Serializable{

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RPGCharacter nextCharacter : this) {
            sb.append(nextCharacter.toString() + "\n");
        }

        return sb.toString();
    }
}
