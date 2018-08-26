package CharacterComponents;

import java.io.Serializable;

/**
 * @author Yurichi
 */
public abstract class JobMain implements Serializable{

    int id;
    String name;
    JobMainStats jobStats;

    String bio;

    public JobMain() {

    }

    public JobMain(String newName, int newID, JobMainStats newJobStats) {
        //Base Constructor that should be implementable by all subclasses
        name = newName;
        id = newID;
        jobStats = newJobStats;
    }

    public JobMain(JobMain original) {
        //Copy Constructor
        this();
        id = original.getId();
        name = new String(original.getName());
        jobStats = new JobMainStats(original.getJobStats());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public JobMainStats getJobStats() {
        return jobStats;
    }

    public int getRank() {
        return jobStats.getRank();
    }
    
    public int getMaxRank(){
        return jobStats.getMaxRank();
    }

    public int getAtk() {
        return jobStats.getAtk();
    }

    public int getDef() {
        return jobStats.getDef();
    }

    public int getMDef() {
        return jobStats.getMDef();
    }

    public int getSpd() {
        return jobStats.getSpd();
    }
    
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Job\n");
        sb.append("ID: " + "\t" + id + "\n");
        sb.append("Name: " + "\t" + name + "\n");
        sb.append(jobStats.toString());
        
        return sb.toString();
    }

}
