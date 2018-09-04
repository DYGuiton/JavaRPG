package javarpg;

import CharacterComponents.*;
import DataManagement.CharacterList;
import DataManagement.CharacterMap;
import DataManagement.RPGDatabase;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class Guild implements Serializable {

    RPGCharacterPlayable leader;
    PlayerParty myParty;
    RPGDatabase theRPGDatabase;
    CharacterList guildMembersList;
    CharacterMap guildMembersMap;

    String name;
    int size;

    private int munny;

    public Guild(RPGDatabase theRPGDatabase) {
        this.theRPGDatabase = theRPGDatabase;
        guildMembersList = new CharacterList();
        guildMembersMap = new CharacterMap();
        setLeader();
        guildMembersList.add(leader);
        guildMembersMap.put(leader);
        myParty = new PlayerParty(leader);
        
        name = "Knights of the Blood Oath";

        munny = 10;

        addTestMembers();

    }

    private void setLeader() {
        //sets the RPGCharacter to the created character in the NewGamePanel upon starting a new game.
        leader = (RPGCharacterPlayable) theRPGDatabase.copyPlayableCharacterById(0);
        size++;
    }

    public void addGuildMember(int nuCharacterID) {
        if (guildMembersMap.getByID(nuCharacterID) == null) {
            RPGCharacterPlayable nuMember = (RPGCharacterPlayable) theRPGDatabase.copyPlayableCharacterById(nuCharacterID);
            guildMembersList.add(nuMember);
            guildMembersMap.put(nuMember);
            size++;
        }
    }

    public RPGCharacter removeGuildMember(int characterID) {

        if (characterID != leader.getId()) {
            removePartyMember(characterID);

            RPGCharacter removeCharacter = guildMembersMap.removeByID(characterID);
            guildMembersList.remove(removeCharacter);

            size--;
            return removeCharacter;
        }

        return null;

    }

    public boolean addPartyMember(int characterID) {
        for (RPGCharacter nextCharacter : guildMembersList) {
            if (nextCharacter.getId() == characterID) {
                myParty.addCharacter(nextCharacter);
                return true;
            }
        }
        return false;
    }

    public RPGCharacter removePartyMember(int characterID) {
        return myParty.removeCharacter(characterID);
    }

    public String getName() {
        return name;
    }

    public Party getParty() {
        return myParty;
    }

    public int getMunny() {
        return munny;
    }

    public int subtractMunny(int cost) {
        munny = munny - cost;
        return munny;
    }

    public int addMunny(int pay) {
        munny = munny + pay;
        return munny;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("This is Guild: " + name);
        sb.append("Size: " + size);
        sb.append("Leader: " + leader.getName());
        sb.append("Current Party Size: " + myParty.getSize());

        return sb.toString();
    }

    private void addTestMembers() {
        addGuildMember(1);
        addPartyMember(1);
        addGuildMember(2);
        addPartyMember(2);
        addGuildMember(3);
        addPartyMember(3);

    }
}
