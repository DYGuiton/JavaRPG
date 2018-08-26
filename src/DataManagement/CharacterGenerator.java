package DataManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

/**
 * @author Yurichi
 */
public class CharacterGenerator {
    
    

    public CharacterGenerator() {

    }

//    public RPGCharacterPlayable genRPGCharacterPlayableFromSQLQuery(ResultSet playableCharacterProfileTable,
//            ResultSet playableCharacterJobTable) throws Exception {
//
//        String name = playableCharacterProfileTable.getString("name");
//        int id = playableCharacterProfileTable.getInt("id");
//        int gender = playableCharacterProfileTable.getInt("gender");
//        int hp = playableCharacterProfileTable.getInt("hp");
//        int sp = playableCharacterProfileTable.getInt("sp");
//        int crit = playableCharacterProfileTable.getInt("crit");
//        int agl = playableCharacterProfileTable.getInt("agl");
//        int jobId = playableCharacterProfileTable.getInt("startingjobid");
//
//        //Creates new ProfileStats(hp, sp, crit, agl)
//        ProfileStats newProfileStats = new ProfileStats(hp, sp, crit, agl);
//
//        //Creates new RPGCharacterType Profile(name, id, gender, ProfileStats)
//        //ProfilePlayable newProfilePlayable = new ProfilePlayable(name, id, gender, newProfileStats);
//
//        String jobName = playableCharacterJobTable.getString("name");
//        int skillTree = playableCharacterJobTable.getInt("skillTree");
//        int atk = playableCharacterJobTable.getInt("atk");
//        int mag = playableCharacterJobTable.getInt("mag");
//        int def = playableCharacterJobTable.getInt("def");
//        int mdef = playableCharacterJobTable.getInt("mdef");
//        int res = playableCharacterJobTable.getInt("mdef");
//        int spd = playableCharacterJobTable.getInt("spd");
//
//        //Creates new JobStats(atk, def, mdef, res, spd);
//        JobStats newJobStats = new JobStats(atk, def, mag, mdef, res, spd);
//
//        //Creates new Job(name, id, JobStats)
//        JobPlayable newJobPlayable = new JobPlayable(jobName, jobId, newJobStats);
//
//        //Creates new RPGCharacterType(Profile, Job)
//        RPGCharacterPlayable newRPGCharacterPlayable = new RPGCharacterPlayable(newProfilePlayable, newJobPlayable);
//
//        return newRPGCharacterPlayable;
//    }
//
//    public RPGCharacterEnemy genRPGCharacterEnemyFromSQLQuery(ResultSet enemyCharacterProfileTable,
//            ResultSet enemyCharacterJobTable) throws Exception {
//
//        String name = enemyCharacterProfileTable.getString("name");
//        int id = enemyCharacterProfileTable.getInt("id");
//        int gender = enemyCharacterProfileTable.getInt("gender");
//        int hp = enemyCharacterProfileTable.getInt("hp");
//        int sp = enemyCharacterProfileTable.getInt("sp");
//        int crit = enemyCharacterProfileTable.getInt("crit");
//        int agl = enemyCharacterProfileTable.getInt("agl");
//        int jobId = enemyCharacterProfileTable.getInt("startingjobid");
//
//        //Creates new ProfileStats(hp, sp, crit, agl)
//        ProfileStats newProfileStats = new ProfileStats(hp, sp, crit, agl);
//
//        //Creates new RPGCharacterType Profile(name, id, gender, ProfileStats)
//        //ProfileEnemy newProfileEnemy = new ProfileEnemy(name, id, gender, newProfileStats);
//
//        String jobName = enemyCharacterJobTable.getString("name");
//        int skillTree = enemyCharacterJobTable.getInt("skillTree");
//        int atk = enemyCharacterJobTable.getInt("atk");
//        int mag = enemyCharacterJobTable.getInt("mag");
//        int def = enemyCharacterJobTable.getInt("def");
//        int mdef = enemyCharacterJobTable.getInt("mdef");
//        int res = enemyCharacterJobTable.getInt("mdef");
//        int spd = enemyCharacterJobTable.getInt("spd");
//
//        //Creates new JobStats(atk, def, mdef, res, spd);
//        JobStats newJobStats = new JobStats(atk, def, mag, mdef, res, spd);
//
//        //Creates new Job(name, id, JobStats)
//        JobEnemy newJobEnemy = new JobEnemy(jobName, jobId, newJobStats);
//
//        //Creates new RPGCharacterType(Profile, Job)
//        //RPGCharacterEnemy newRPGCharacterEnemy = new RPGCharacterEnemy(newProfileEnemy, newJobEnemy);
//
//        return newRPGCharacterEnemy;
//    }

}
