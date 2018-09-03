package javarpg;

import CharacterComponents.*;
import DataManagement.CharacterList;

/**
 * @author Yurichi
 */
public abstract class Party {

    String title;
    CharacterList partyMembers = new CharacterList();
    int lvl, xp, size;
    final static int MAXPARTYSIZE = 4;
    RPGCharacter leader;

    public Party(RPGCharacter nuLeader) {
        leader = nuLeader;
        partyMembers.add(leader);
        lvl = 0;
        xp = 0;
        size = 1;
    }

    public boolean addCharacter(RPGCharacter nuCharacter) {
        if (size < MAXPARTYSIZE) {
            partyMembers.add(nuCharacter);
            size = partyMembers.size();
            return true;
        }
        return false;
    }

    public RPGCharacter removeCharacter(int characterID) {
        if (characterID != leader.getId()) {
            if (partyMembers.size() != 1) {
                for (int i = 0; i < partyMembers.size(); i++) {
                    RPGCharacter nextCharacter = partyMembers.get(i);
                    if (nextCharacter.getId() == characterID) {
                        return partyMembers.remove(i);
                    }
                }
            }
        }
        return null;
    }

    public void lvlUp() {

    }

    public CharacterList getPartyMembers() {
        return partyMembers;
    }

    public int getSize() {
        return size;
    }

    public RPGCharacter getLeader() {
        return leader;
    }

    public RPGCharacter getCharacter(int i) {
        return partyMembers.get(i);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (RPGCharacter nextCharacter : partyMembers) {
            sb.append(nextCharacter.toString() + "\n");
        }
        return sb.toString();
    }
}
