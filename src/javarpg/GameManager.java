package javarpg;

import DataManagement.RPGDatabase;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class GameManager implements Serializable{

    private static final long serialVersionUID = 2495329415231318524L;

    Game theGame;
    protected RPGDatabase theRPGDatabase;
    UserManager theUserManager;
    //BattleManager theBattleManager;

    public GameManager(){
        
    }
    
    public GameManager(Game theGame) {
        this.theGame = theGame;
        theRPGDatabase = new RPGDatabase();
        //theUserManager = new UserManager(theRPGDatabase);
    }
    
    public GameManager(Game theGame, GameManager savedGameManager){
        //copy constructor
        this();
        this.theGame = theGame;
        theRPGDatabase = savedGameManager.getRPGDatabase();
    }
    
    public void createUserManager(){
        theUserManager = new UserManager(theRPGDatabase);
    }

    public RPGDatabase getRPGDatabase() {
        return theRPGDatabase;
    }
    
    public UserManager getUserManager(){
        return theUserManager;
    }
    
    @Override
    public String toString(){
        return theRPGDatabase.getCharacterData().toString();
    }
}
