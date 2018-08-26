package javarpg;

import CharacterComponents.RPGCharacter;
import CharacterComponents.RPGCharacterPlayable;
import DataManagement.RPGDatabase;
import java.io.Serializable;
import javax.swing.JOptionPane;

/**
 * @author Yurichi
 */
public class UserManager implements Serializable{
    
    RPGDatabase theRPGDatabase;
    Guild myGuild;
    
    public UserManager(RPGDatabase theRPGDatabase) {
        this.theRPGDatabase = theRPGDatabase;
        myGuild = new Guild(theRPGDatabase);
        
    }

}
