package CharacterComponents;

import java.io.Serializable;

/**
 * @author Yurichi
 */
public abstract class JobSub implements Serializable{

    private int id;
    private String name;
    //SubJobSkill[] learnedSkillList = new SubJobSkill[]; 

    String bio;

    public JobSub() {

    }

    public JobSub(String newName, int newID) {
        //Base Constructor that should be implementable by all subclasses
        name = newName;
        id = newID;
    }

    public JobSub(JobSub original) {
        //Copy Constructor
        this();
        id = original.getId();
        name = new String(original.getName());
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Job\n");
        sb.append("ID: " + "\t" + id + "\n");
        sb.append("Name: " + "\t" + name + "\n");
        return sb.toString();
    }

}
