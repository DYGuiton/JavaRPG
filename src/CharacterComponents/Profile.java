package CharacterComponents;

import java.util.ArrayList;
import CharacterComponents.ProfileStats;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public abstract class Profile implements Serializable{

    private int id;
    private String name;
    private int gender;
    private int mainJobId;
    private ProfileStats profileStats;
    private ArrayList<Integer> learnedSubJobIds;

    String bio;

    public Profile() {

    }

    public Profile(String nuName, int nuID, int nuGender, int nuStartingJobId, 
            ProfileStats nuProfileStats, ArrayList<Integer> nuSubJobIds) {
        //Base Contructor that should be implementable by all subclasses
        id = nuID;
        name = nuName;
        gender = nuGender;
        mainJobId = nuStartingJobId;
        profileStats = nuProfileStats;
        learnedSubJobIds = nuSubJobIds;
    }

    public Profile(Profile original) {
        this();
        id = original.getId();
        name = new String(original.getName());
        gender = original.getGender();
        mainJobId = original.getMainJobId();
        profileStats = new ProfileStats(original.getProfileStats());
        learnedSubJobIds = new ArrayList<>(original.getLearnedSubJobIds());
    }

    public String getGenderToString() {
        switch (gender) {
            case 0:
                return "Female";
            case 1:
                return "Male";
            case 2:
                return "Non-Binary";
            default:
                return "Non-Binary";
        }
    }

    public abstract String getJobToString(int jobID);

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getGender() {
        return gender;
    }

    public int getMainJobId() {
        return mainJobId;
    }

    public ProfileStats getProfileStats() {
        return profileStats;
    }

    public ArrayList<Integer> getLearnedSubJobIds() {
        return learnedSubJobIds;
    }

    public int getLvl() {
        return profileStats.getLvl();
    }

    public int getXp() {
        return profileStats.getXp();
    }

    public int getMaxXp() {
        return profileStats.getMaxXp();
    }

    public int getHp() {
        return profileStats.getHp();
    }

    public int getSp() {
        return profileStats.getSp();
    }

    public int getCrit() {
        return profileStats.getCrit();
    }

    public int getAgl() {
        return profileStats.getAgl();
    }

    public int getCurrentHp() {
        return profileStats.getCurrentHp();
    }

    public int getCurrentSp() {
        return profileStats.getCurrentSp();
    }

    public Profile getProfile() {
        return this;
    }

    public String toString() {
        //id, name, gender, startingjobid, ProfileStats
        StringBuilder sb = new StringBuilder();
        sb.append("Profile\n");
        sb.append("ID: " + "\t" + id + "\n");
        sb.append("NAME: " + "\t" + name + "\n");
        sb.append("GENDER: " + "\t" + getGenderToString() + "\n");
        sb.append("Main Job: " + "\t" + getJobToString(mainJobId) + "\n");
        sb.append(profileStats.toString());

        return sb.toString();
    }

}
