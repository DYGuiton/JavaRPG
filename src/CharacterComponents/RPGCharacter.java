package CharacterComponents;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Formatter;

/**
 * @author Yurichi
 */
public abstract class RPGCharacter implements Serializable{

    Profile myProfile;
    JobMain myMainJob;
    SubJobContainer mySubJobContainer;

    //empty default constructor
    public RPGCharacter() {

    }

    //normal constructor
    public RPGCharacter(Profile newProfile, JobMain nuMainJob, SubJobContainer nuSubJobs) {
        myProfile = newProfile;
        myMainJob = nuMainJob;
        mySubJobContainer = nuSubJobs;
    }

    public Profile getProfile() {
        return myProfile;
    }

    public JobMain getMainJob() {
        return myMainJob;
    }

    public SubJobContainer getSubJobs() {
        return mySubJobContainer;
    }

    public JobSub getCurrentSubJob() {
        return mySubJobContainer.getCurrentSubJob();
    }

    public JobSubList getLearnedSubJobList() {
        return mySubJobContainer.getJobSubList();
    }

    public int getId() {
        return myProfile.getId();
    }

    public String getName() {
        return myProfile.getName();
    }

    public int getGender() {
        return myProfile.getGender();
    }

    public String getGenderString() {
        return myProfile.getGenderToString();
    }

    public int getHP() {
        return myProfile.getHp();
    }

    public int getCurrentHP() {
        return myProfile.getCurrentHp();
    }

    public int getSP() {
        return myProfile.getSp();
    }

    public int getCurrentSP() {
        return myProfile.getCurrentSp();
    }

    public int getCritical() {
        return myProfile.getCrit();
    }

    public int getAgility() {
        return myProfile.getAgl();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Character\n");
        sb.append(myProfile.toString());
        sb.append(myMainJob.toString());
        sb.append("LEARNED SUBJOBS: " + getLearnedSubJobList().toString());

        return sb.toString();
    }

}
