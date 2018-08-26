package IO;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Yurichi
 */
public class SQLLoader {

//    public SQLLoader() {
//
//    }
//
//    public ProfilePlayable loadProfilePlayableFromSQLQuery(ResultSet playableCharacterProfileTable) throws Exception {
//        String name = playableCharacterProfileTable.getString("name");
//        int id = playableCharacterProfileTable.getInt("id");
//        int gender = playableCharacterProfileTable.getInt("gender");
//        int hp = playableCharacterProfileTable.getInt("hp");
//        int sp = playableCharacterProfileTable.getInt("sp");
//        int crit = playableCharacterProfileTable.getInt("crit");
//        int agl = playableCharacterProfileTable.getInt("agl");
//        int jobId = playableCharacterProfileTable.getInt("mainjobid");
//
//        //Creates new ProfileStats(hp, sp, crit, agl)
//        ProfileStats nuProfileStats = new ProfileStats(hp, sp, crit, agl);
//
//        //Creates new RPGCharacterType Profile(name, id, gender, ProfileStats)
//        ProfilePlayable nuProfilePlayable = new ProfilePlayable(name, id, gender, jobId, nuProfileStats);
//
//        return nuProfilePlayable;
//    }
//
//    public ProfileEnemy loadProfileEnemyFromSQLQuery(ResultSet enemyCharacterProfileTable) throws Exception {
//
//        String name = enemyCharacterProfileTable.getString("name");
//        int id = enemyCharacterProfileTable.getInt("id");
//        int gender = enemyCharacterProfileTable.getInt("gender");
//        int hp = enemyCharacterProfileTable.getInt("hp");
//        int sp = enemyCharacterProfileTable.getInt("sp");
//        int crit = enemyCharacterProfileTable.getInt("crit");
//        int agl = enemyCharacterProfileTable.getInt("agl");
//        int jobId = enemyCharacterProfileTable.getInt("mainjobid");
//
//        //Creates new ProfileStats(hp, sp, crit, agl)
//        ProfileStats nuProfileStats = new ProfileStats(hp, sp, crit, agl);
//
//        //Creates new RPGCharacterType Profile(name, id, gender, ProfileStats)
//        ProfileEnemy nuProfileEnemy = new ProfileEnemy(name, id, gender, jobId, nuProfileStats);
//
//        return nuProfileEnemy;
//    }
//
//    public JobMainPlayable loadJobPlayableFromSQLQuery(ResultSet playableCharacterJobTable) throws Exception {
//
//        //load SQLDatabase values into temporary variables
//        String jobName = playableCharacterJobTable.getString("name");
//        int id = playableCharacterJobTable.getInt("id");
//        int skillTree = playableCharacterJobTable.getInt("skillTree");
//        int atk = playableCharacterJobTable.getInt("atk");
//        int mag = playableCharacterJobTable.getInt("mag");
//        int def = playableCharacterJobTable.getInt("def");
//        int mdef = playableCharacterJobTable.getInt("mdef");
//        int res = playableCharacterJobTable.getInt("mdef");
//        int spd = playableCharacterJobTable.getInt("spd");
//
//        //Creates new JobMainStats(atk, def, mdef, res, spd);
//        JobMainStats nuJobStats = new JobMainStats(atk, def, mag, mdef, res, spd);
//
//        //Creates new Job(name, id, JobMainStats)
//        JobMainPlayable nuJobPlayable = new JobMainPlayable(jobName, id, nuJobStats);
//
//        return nuJobPlayable;
//    }
//
//    public JobMainEnemy loadJobEnemyFromSQLQuery(ResultSet enemyCharacterJobTable) throws Exception {
//
//        //load SQLDatabase values into temporary variables
//        String jobName = enemyCharacterJobTable.getString("name");
//        int id = enemyCharacterJobTable.getInt("id");
//        int skillTree = enemyCharacterJobTable.getInt("skillTree");
//        int atk = enemyCharacterJobTable.getInt("atk");
//        int mag = enemyCharacterJobTable.getInt("mag");
//        int def = enemyCharacterJobTable.getInt("def");
//        int mdef = enemyCharacterJobTable.getInt("mdef");
//        int res = enemyCharacterJobTable.getInt("mdef");
//        int spd = enemyCharacterJobTable.getInt("spd");
//
//        //Creates new JobMainStats(atk, def, mdef, res, spd);
//        JobMainStats nuJobStats = new JobMainStats(atk, def, mag, mdef, res, spd);
//
//        //Creates new Job(name, id, JobMainStats)
//        JobMainEnemy nuJobEnemy = new JobMainEnemy(jobName, id, nuJobStats);
//
//        return nuJobEnemy;
//    }
//
//    JobSubPlayable loadJobSubPlayableFromSQLQuery(ResultSet playableSubJobsTable) throws SQLException {
//        String jobName = playableSubJobsTable.getString("name");
//        int id = playableSubJobsTable.getInt("id");
//
//        //Creates new Job(name, id, JobMainStats)
//        JobSubPlayable nuSubJobPlayable = new JobSubPlayable(jobName, id);
//
//        return nuSubJobPlayable;
//    }
//
//    JobSubEnemy loadJobSubEnemyFromSQLQuery(ResultSet enemySubJobsTable) throws SQLException {
//        String jobName = enemySubJobsTable.getString("name");
//        int id = enemySubJobsTable.getInt("id");
//
//        //Creates new Job(name, id, JobMainStats)
//        JobSubEnemy nuSubJobEnemy = new JobSubEnemy(jobName, id);
//
//        return nuSubJobEnemy;
//    }
}
