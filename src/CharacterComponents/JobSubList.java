package CharacterComponents;

import java.util.ArrayList;

/** @author Yurichi*/
public class JobSubList extends ArrayList<JobSub>{

    public JobSubList(){
        super();
    }
    
    public JobSubList(JobSubList copyList){
        //copy constructor
        for (JobSub jobSub : copyList) {
            this.add(jobSub);
        }
    }
    
       public String toString(){
           StringBuilder sb = new StringBuilder();
           for(JobSub nextJob: this){
               sb.append(nextJob.toString() + "\n");
           }
           
           return sb.toString();
       }
    
}
