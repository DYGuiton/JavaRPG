package DataManagement;

import CharacterComponents.JobSubPlayable;
import CharacterComponents.JobSubEnemy;
import CharacterComponents.JobSub;
import IO.FileLoader;
import java.io.Serializable;
import java.sql.ResultSet;

/**
 * @author Yurichi
 */
public class JobSubData implements Serializable{

    private JobSubList thePlayableJobSubList;
    private JobSubMap thePlayableJobSubMap;

    private JobSubList theEnemyJobSubList;
    private JobSubMap theEnemyJobSubMap;

    public JobSubData() {
        populateDataStructures();
    }

    private void populateDataStructures() {
        populatePlayerDataStructures();
        populateEnemyDataStructures();
    }

    private void populatePlayerDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/SubJobs/PlayableSubJobs");

        thePlayableJobSubList = (JobSubList) theLoadedFile.loadPlayableSubJobs();
        thePlayableJobSubMap = new JobSubMap();

        for (JobSub jobSub : thePlayableJobSubList) {
            thePlayableJobSubMap.put(jobSub);
        }

    }

    private void populateEnemyDataStructures() {
        FileLoader theLoadedFile = new FileLoader("Data/SubJobs/EnemySubJobs");

        theEnemyJobSubList = (JobSubList) theLoadedFile.loadEnemySubJobs();
        theEnemyJobSubMap = new JobSubMap();

        for (JobSub jobSub : theEnemyJobSubList) {
            theEnemyJobSubMap.put(jobSub);
        }

    }

    private void storeJobPlayable(JobSubPlayable nuPlayableJob) {
        thePlayableJobSubList.add(nuPlayableJob);
        thePlayableJobSubMap.put(nuPlayableJob);
    }

    private void storeJobEnemy(JobSubEnemy nuEnemyJob) {
        theEnemyJobSubList.add(nuEnemyJob);
        theEnemyJobSubMap.put(nuEnemyJob);
    }

    public JobSub getJobPlayableById(int id) {
        return thePlayableJobSubMap.getByID(id);
    }

    public JobSub getJobPlayableByName(String name) {
        return thePlayableJobSubMap.getByName(name);
    }

    public JobSub getJobEnemyById(int id) {
        return theEnemyJobSubMap.getByID(id);
    }

    public JobSub getJobEnemyByName(String name) {
        return theEnemyJobSubMap.getByName(name);
    }

    public JobSub copyJobPlayableById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        JobSubPlayable copyJob = new JobSubPlayable((JobSubPlayable) getJobPlayableById(id));
        return copyJob;
    }

    public JobSub copyJobEnemyById(int id) {
        //Deep copies the character so that we're not referencing the stored object in the database
        JobSubEnemy copyJob = new JobSubEnemy((JobSubEnemy) getJobEnemyById(id));
        return copyJob;
    }

    public JobSubList getPlayableJobList() {
        return thePlayableJobSubList;
    }

    public JobSubList getEnemyJobList() {
        return theEnemyJobSubList;
    }

    public JobSubMap getPlayableJobMap() {
        return this.thePlayableJobSubMap;
    }

    public JobSubMap getEnemyJobMap() {
        return this.theEnemyJobSubMap;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (JobSub nextJob : thePlayableJobSubList) {
            sb.append(nextJob.toString());
        }
        return sb.toString();
    }

    //    RELIC CODE FROM DATABASE FORMATION USING MYSQL DATABASE 
//    private void populateEnemyDataStructures() throws Exception {
//        SQLConnector theSQLConnector = new SQLConnector();
//        SQLLoader theSQLLoader = new SQLLoader();
//
//        theEnemyJobSubList = new JobSubList();
//        theEnemyJobSubMap = new JobSubMap();
//        try {
//
//            ResultSet enemySubJobsTable = theSQLConnector.getTable("enemy_sub_jobs");
//
//            while (enemySubJobsTable.next()) {
//
//                JobSubEnemy nuEnemyJob = theSQLLoader.loadJobSubEnemyFromSQLQuery(enemySubJobsTable);
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
