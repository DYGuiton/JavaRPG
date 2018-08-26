package DataManagement;

import CharacterComponents.JobMainEnemy;
import CharacterComponents.JobMain;
import CharacterComponents.JobMainPlayable;
import IO.FileLoader;
import java.io.Serializable;
import java.sql.ResultSet;

/**
 * @author Yurichi
 */
public class JobMainData implements Serializable{

    private JobMainList thePlayableJobList;
    private JobMainMap thePlayableJobMap;

    private JobMainList theEnemyJobList;
    private JobMainMap theEnemyJobMap;

    public JobMainData() {
        populateDataStructures();
    }

    private void populateDataStructures() {
        populatePlayerDataStructures();
        populateEnemyDataStructures();
    }

    private void populatePlayerDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/MainJobs/PlayableMainJobs");

        thePlayableJobList = (JobMainList) theLoadedFile.loadPlayableMainJobs();
        thePlayableJobMap = new JobMainMap();

        for (JobMain jobMain : thePlayableJobList) {
            thePlayableJobMap.put(jobMain);
        }

    }

    private void populateEnemyDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/MainJobs/EnemyMainJobs");

        theEnemyJobList = (JobMainList) theLoadedFile.loadEnemyMainJobs();
        theEnemyJobMap = new JobMainMap();

        for (JobMain jobMain : theEnemyJobList) {
            theEnemyJobMap.put(jobMain);
        }

    }

    private void storeJobPlayable(JobMainPlayable nuPlayableJob) {
        thePlayableJobList.add(nuPlayableJob);
        thePlayableJobMap.put(nuPlayableJob);
    }

    private void storeJobEnemy(JobMainEnemy nuEnemyJob) {
        theEnemyJobList.add(nuEnemyJob);
        theEnemyJobMap.put(nuEnemyJob);
    }

    public JobMain getJobPlayableById(int id) {
        return thePlayableJobMap.getByID(id);
    }

    public JobMain getJobPlayableByName(String name) {
        return thePlayableJobMap.getByName(name);
    }

    public JobMain getJobEnemyById(int id) {
        return theEnemyJobMap.getByID(id);
    }

    public JobMain getJobEnemyByName(String name) {
        return theEnemyJobMap.getByName(name);
    }

    public JobMain copyJobPlayableById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        JobMainPlayable copyJob = new JobMainPlayable((JobMainPlayable) getJobPlayableById(id));
        return copyJob;
    }

    public JobMain copyJobEnemyById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        JobMainEnemy copyJob = new JobMainEnemy((JobMainEnemy) getJobEnemyById(id));
        return copyJob;
    }

    public JobMainList getPlayableJobList() {
        return thePlayableJobList;
    }

    public JobMainList getEnemyJobList() {
        return theEnemyJobList;
    }

    public JobMainMap getPlayableJobMap() {
        return this.thePlayableJobMap;
    }

    public JobMainMap getEnemyJobMap() {
        return this.theEnemyJobMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (JobMain nextJob : thePlayableJobList) {
            sb.append(nextJob.toString());
        }
        return sb.toString();
    }

    //    RELIC CODE FROM DATABASE FORMATION USING MYSQL DATABASE    
//    private void populateEnemyDataStructures() throws Exception {
//        SQLConnector theSQLConnector = new SQLConnector();
//        SQLLoader theSQLLoader = new SQLLoader();
//
//        theEnemyJobList = new JobMainList();
//        theEnemyJobMap = new JobMainMap();
//        try {
//
//            ResultSet enemyJobsTable = theSQLConnector.getTable("enemy_jobs");
//
//            while (enemyJobsTable.next()) {
//
//                JobMainEnemy nuEnemyJob = theSQLLoader.loadJobEnemyFromSQLQuery(enemyJobsTable);
//
//                storeJobEnemy(nuEnemyJob);
//
//            }
//        } catch (Exception e) {
//
//            System.out.println(e);
//
//        }
//    }
}
