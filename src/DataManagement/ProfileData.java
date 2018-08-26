package DataManagement;

import IO.FileLoader;
import java.sql.ResultSet;
import java.util.ArrayList;
import CharacterComponents.Profile;
import CharacterComponents.ProfileEnemy;
import CharacterComponents.ProfilePlayable;
import java.io.Serializable;

/**
 * @author Yurichi
 */
class ProfileData implements Serializable{

    private ProfileList thePlayableProfileList;
    private ProfileMap thePlayableProfileMap;

    private ProfileList theEnemyProfileList;
    private ProfileMap theEnemyProfileMap;

    public ProfileData() {
        populateDataStructures();
    }

    private void populateDataStructures() {
        populatePlayerDataStructures();
        populateEnemyDataStructures();
    }

    private void populatePlayerDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/Profiles/PlayableProfiles");

        thePlayableProfileList = (ProfileList) theLoadedFile.loadPlayableProfiles();
        thePlayableProfileMap = new ProfileMap();

        for (Profile profile : thePlayableProfileList) {
            thePlayableProfileMap.put(profile);
        }

    }

    private void populateEnemyDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/Profiles/EnemyProfiles");

        theEnemyProfileList = (ProfileList) theLoadedFile.loadEnemyProfiles();
        theEnemyProfileMap = new ProfileMap();

        for (Profile profile : theEnemyProfileList) {
            theEnemyProfileMap.put(profile);
        }

    }

    private void storeProfilePlayable(ProfilePlayable nuPlayableProfile) {
        thePlayableProfileList.add(nuPlayableProfile);
        thePlayableProfileMap.put(nuPlayableProfile);
    }

    private void storeProfileEnemy(ProfileEnemy nuEnemyProfile) {
        theEnemyProfileList.add(nuEnemyProfile);
        theEnemyProfileMap.put(nuEnemyProfile);
    }

    public Profile getProfilePlayableById(int id) {
        return thePlayableProfileMap.getByID(id);
    }

    public Profile getProfilePlayableByName(String name) {
        return thePlayableProfileMap.getByName(name);
    }

    public Profile getProfileEnemyById(int id) {
        return theEnemyProfileMap.getByID(id);
    }

    public Profile getProfileEnemyByName(String name) {
        return theEnemyProfileMap.getByName(name);
    }

    public Profile copyProfilePlayableById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        ProfilePlayable copyProfile = new ProfilePlayable((ProfilePlayable) getProfilePlayableById(id));
        return copyProfile;
    }

    public Profile copyProfileEnemyById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        ProfileEnemy copyProfile = new ProfileEnemy((ProfileEnemy) getProfileEnemyById(id));
        return copyProfile;
    }

    public ProfileList getPlayableProfileList() {
        return thePlayableProfileList;
    }

    public ProfileList getEnemyProfileList() {
        return theEnemyProfileList;
    }

    public ProfileMap getPlayableProfileMap() {
        return this.thePlayableProfileMap;
    }

    public ProfileMap getEnemyProfileMap() {
        return this.theEnemyProfileMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Profile nextProfile : thePlayableProfileList) {
            sb.append(nextProfile.toString());
        }
        return sb.toString();
    }

//    RELIC CODE FROM DATABASE FORMATION USING MYSQL DATABASE
//    private void populateEnemyDataStructures() throws Exception {
//        SQLConnector theSQLConnector = new SQLConnector();
//        SQLLoader theSQLLoader = new SQLLoader();
//
//        theEnemyProfileList = new ProfileList();
//        theEnemyProfileMap = new ProfileMap();
//        try {
//
//            ResultSet enemyProfilesTable = theSQLConnector.getTable("enemy_profiles");
//
//            while (enemyProfilesTable.next()) {
//
//                ProfileEnemy nuEnemyProfile = theSQLLoader.loadProfileEnemyFromSQLQuery(enemyProfilesTable);
//
//                storeProfileEnemy(nuEnemyProfile);
//
//            }
//        } catch (Exception e) {
//
//            System.out.println(e);
//
//        }
//    }
}
