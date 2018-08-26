package javarpg;

import UI.NewGamePanel;
import DataManagement.RPGDatabase;
import UI.*;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class Game implements Serializable {

    GameManager theGameManager;
    InterfaceFrame theInterfaceFrame;
    MainMenuPanel theMainMenuPanel;
    DatabasePanel theDatabasePanel;
    GuildMenuPanel theGuildPanel;

    private Boolean isInterfaceVisible = false;

    public Game() {

        theInterfaceFrame = new InterfaceFrame(this);

        theMainMenuPanel = new MainMenuPanel(theInterfaceFrame);

        theInterfaceFrame.setMainMenuPanel(theMainMenuPanel);
        theInterfaceFrame.setCurrentPanel(theMainMenuPanel);

        setInterfaceVisibility(true);

    }

    public void setInterfaceVisibility(boolean visibility) {
        theInterfaceFrame.setVisible(isInterfaceVisible = visibility);
    }

    public Boolean getInterfaceVisibility() {
        return isInterfaceVisible;
    }

    public RPGDatabase getRPGDatabase() {
        return theGameManager.getRPGDatabase();
    }

    public UserManager getUserManager() {
        return theGameManager.getUserManager();
    }

    public void createNewGame() {
        theGameManager = new GameManager(this);
        theDatabasePanel = new DatabasePanel(theInterfaceFrame, theGameManager.getRPGDatabase());
        theInterfaceFrame.setDatabasePanel(theDatabasePanel);

        NewGamePanel theNewGamePanel = new NewGamePanel(theInterfaceFrame, theGameManager);
        theInterfaceFrame.setNewGamePanel(theNewGamePanel);
        theInterfaceFrame.setCurrentPanel(theNewGamePanel);
    }

    public void startNewGame() {
        theGameManager.createUserManager();
        theGuildPanel = new GuildMenuPanel(theInterfaceFrame);
        theInterfaceFrame.setGuildMenuPanel(theGuildPanel);
        theInterfaceFrame.openGuildMenuPanel();
    }

    public void startGame(GameManager savedGameManager) {
        theGameManager = savedGameManager;
        theGameManager.createUserManager();
        theGuildPanel = new GuildMenuPanel(theInterfaceFrame);
        theInterfaceFrame.setGuildMenuPanel(theGuildPanel);
        theInterfaceFrame.openGuildMenuPanel();

    }

}
