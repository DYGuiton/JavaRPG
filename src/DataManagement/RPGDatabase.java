package DataManagement;

import CharacterComponents.RPGCharacter;
import DataManagement.CharacterData;
import java.io.Serializable;
import java.sql.ResultSet;

/**
 * @author Yurichi
 */
public class RPGDatabase implements Serializable{

    CharacterData theCharacterData;
    //private SQLConnector theSQLConnector;

    public RPGDatabase() {
        //theSQLConnector = new SQLConnector();
        populateDataClasses();
        //System.out.println(theCharacterData.toString());
    }

    private void populateDataClasses() {
        theCharacterData = new CharacterData();
    }

    public RPGCharacter getPlayableCharacterById(int id) {
        return theCharacterData.getPlayableCharacterById(id);
    }

    public RPGCharacter getPlayableCharacterByName(String name) {
        return theCharacterData.getPlayableCharacterByName(name);
    }

    public RPGCharacter getEnemyCharacterById(int id) {
        return theCharacterData.getEnemyCharacterById(id);
    }

    public RPGCharacter getEnemyCharacterByName(String name) {
        return theCharacterData.getEnemyCharacterByName(name);
    }

    public RPGCharacter copyPlayableCharacterById(int id) {
        return theCharacterData.copyPlayableCharacterById(id);
    }

    public RPGCharacter copyEnemyCharacterById(int id) {
        return theCharacterData.copyEnemyCharacterById(id);
    }
    
    public CharacterData getCharacterData(){
        return theCharacterData;
    }

}
