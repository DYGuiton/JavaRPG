package DataManagement;

import CharacterComponents.JobMainEnemy;
import CharacterComponents.RPGCharacterPlayable;
import CharacterComponents.JobMainPlayable;
import CharacterComponents.RPGCharacter;
import CharacterComponents.PlayableSubJobContainer;
import CharacterComponents.ProfileEnemy;
import CharacterComponents.EnemySubJobContainer;
import CharacterComponents.ProfilePlayable;
import CharacterComponents.RPGCharacterEnemy;
import CharacterComponents.Profile;
import CharacterComponents.RPGCharacterUser;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class CharacterData implements Serializable {

    JobMainData jobMainData;
    JobSubData jobSubData;
    ProfileData profileData;
    
    private RPGCharacterUser userCharacter;

    private CharacterList thePlayableCharacterList;
    private CharacterMap thePlayableCharacterMap;

    private CharacterList theEnemyCharacterList;
    private CharacterMap theEnemyCharacterMap;

    public CharacterData() {
        populateDataClasses();
        populateDataStructures();
    }

    private void populateDataClasses() {
        profileData = new ProfileData();
        jobMainData = new JobMainData();
        jobSubData = new JobSubData();

    }

    private void populateDataStructures() {
        populatePlayableDataStructures();
        populateEnemyDataStructures();
    }

    private void populatePlayableDataStructures() {

        thePlayableCharacterList = new CharacterList();
        thePlayableCharacterMap = new CharacterMap();

        for (Profile nextPlayableProfile : profileData.getPlayableProfileList()) {

            JobMainPlayable nuMainJob = (JobMainPlayable) jobMainData.getJobPlayableById(nextPlayableProfile.getMainJobId());

            PlayableSubJobContainer nuSubJobsContainer = new PlayableSubJobContainer(nextPlayableProfile.getLearnedSubJobIds(), jobSubData);

            RPGCharacterPlayable nuPlayableCharacter = new RPGCharacterPlayable((ProfilePlayable) nextPlayableProfile, nuMainJob, nuSubJobsContainer, false);

            storePlayableCharacter(nuPlayableCharacter);

        }
    }

    private void populateEnemyDataStructures() {

        theEnemyCharacterList = new CharacterList();
        theEnemyCharacterMap = new CharacterMap();

        for (Profile nextEnemyProfile : profileData.getEnemyProfileList()) {

            JobMainEnemy nuMainJob = (JobMainEnemy) jobMainData.getJobEnemyById(nextEnemyProfile.getMainJobId());

            EnemySubJobContainer nuSubJobsContainer = new EnemySubJobContainer(nextEnemyProfile.getLearnedSubJobIds(), jobSubData);

            RPGCharacterEnemy nuEnemyCharacter = new RPGCharacterEnemy((ProfileEnemy) nextEnemyProfile, nuMainJob, nuSubJobsContainer);

            storeEnemyCharacter(nuEnemyCharacter);
        }
    }

    public void storeUserCharacter(RPGCharacterUser nuUserCharacter) {
        userCharacter = nuUserCharacter;
        
    }
    
    public RPGCharacterUser getUserCharacter(){
        return userCharacter;
    }

    public void storePlayableCharacter(RPGCharacterPlayable nuPlayableCharacter) {
        thePlayableCharacterList.add(nuPlayableCharacter);
        thePlayableCharacterMap.put(nuPlayableCharacter);
    }

    private void storeEnemyCharacter(RPGCharacterEnemy nuEnemyCharacter) {
        theEnemyCharacterList.add(nuEnemyCharacter);
        theEnemyCharacterMap.put(nuEnemyCharacter);
    }

    public RPGCharacter getPlayableCharacterById(int id) {
        return thePlayableCharacterMap.getByID(id);
    }

    public RPGCharacter getPlayableCharacterByName(String name) {
        return thePlayableCharacterMap.getByName(name);
    }

    public RPGCharacter getEnemyCharacterById(int id) {
        return theEnemyCharacterMap.getByID(id);
    }

    public RPGCharacter getEnemyCharacterByName(String name) {
        return theEnemyCharacterMap.getByName(name);
    }

    public CharacterList getPlayableCharacterList() {
        return thePlayableCharacterList;
    }

    public CharacterList getEnemyCharacterList() {
        return theEnemyCharacterList;
    }

    public RPGCharacter copyPlayableCharacterById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        RPGCharacterPlayable copyCharacter = new RPGCharacterPlayable((RPGCharacterPlayable) getPlayableCharacterById(id));
        return copyCharacter;
    }

    public RPGCharacter copyEnemyCharacterById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        RPGCharacterEnemy copyCharacter = new RPGCharacterEnemy((RPGCharacterEnemy) getEnemyCharacterById(id));
        return copyCharacter;
    }

    public ProfileData getProfileData() {
        return profileData;
    }

    public JobMainData getJobMainData() {
        return jobMainData;
    }

    public JobSubData getJobSubData() {
        return jobSubData;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("The Playable Character List:\n" + thePlayableCharacterList.toString() + "\n");
        sb.append("The Enemy Character List:\n" + theEnemyCharacterList.toString() + "\n");

        return sb.toString();
    }

}
