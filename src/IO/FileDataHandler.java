package IO;

import CharacterComponents.JobMainEnemy;
import CharacterComponents.JobSubPlayable;
import CharacterComponents.ProfileStats;
import CharacterComponents.JobMainPlayable;
import CharacterComponents.ProfileEnemy;
import CharacterComponents.JobSubEnemy;
import CharacterComponents.JobMainStats;
import CharacterComponents.ProfilePlayable;
import java.util.ArrayList;
import java.util.Scanner;
import DataManagement.JobMainList;
import DataManagement.JobSubList;
import DataManagement.ProfileList;

/**
 * @author Yurichi
 */
public class FileDataHandler {

    private Scanner sc;

    public FileDataHandler(Scanner nuScanner) {
        sc = nuScanner;
    }

    ProfileList getPlayableProfiles() {
        //#Name
        //#PlayableProfileID - GENDER - LVL - HP - SP - CRIT - AGl - MAINJOBID
        //#LEARNED SUB JOB IDS
        ProfileList profileList = new ProfileList();
        String name;
        int id, gender, lvl, hp, sp, crit, agl, jobId;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();
            gender = sc.nextInt();
            lvl = sc.nextInt();
            hp = sc.nextInt();
            sp = sc.nextInt();
            crit = sc.nextInt();
            agl = sc.nextInt();
            jobId = sc.nextInt();
            sc.nextLine();
            ArrayList<Integer> subJobIds = new ArrayList<>();

            while (sc.hasNextInt()) {
                subJobIds.add(sc.nextInt());
            }

            //Creates new ProfileStats(lvl, hp, sp, crit, agl)
            ProfileStats nuProfileStats = new ProfileStats(lvl, hp, sp, crit, agl);

            //Creates new Profile(name, id, gender, ProfileStats)
            ProfilePlayable nuProfile = new ProfilePlayable(name, id, gender, jobId, nuProfileStats, subJobIds);

            profileList.add(nuProfile);

            //eat the rest of the line
            sc.nextLine();
        }
        return profileList;
    }

    ProfileList getEnemyProfiles() {
        //#Name
        //#PlayableProfileID - GENDER - LVL - HP - SP - CRIT - AGl - MAINJOBID
        ProfileList profileList = new ProfileList();
        String name;
        int id, gender, lvl, hp, sp, crit, agl, jobId;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();
            gender = sc.nextInt();
            lvl = sc.nextInt();
            hp = sc.nextInt();
            sp = sc.nextInt();
            crit = sc.nextInt();
            agl = sc.nextInt();
            jobId = sc.nextInt();
            sc.nextLine();
            ArrayList<Integer> subJobIds = new ArrayList<>();

            while (sc.hasNextInt()) {
                subJobIds.add(sc.nextInt());
            }

            //Creates new ProfileStats(lvl, hp, sp, crit, agl)
            ProfileStats nuProfileStats = new ProfileStats(lvl, hp, sp, crit, agl);

            //Creates new Profile(name, id, gender, ProfileStats)
            ProfileEnemy nuProfile = new ProfileEnemy(name, id, gender, jobId, nuProfileStats, subJobIds);

            profileList.add(nuProfile);

            //eat the rest of the line
            sc.nextLine();
        }
        return profileList;
    }

    JobMainList getPlayableMainJobs() {
        //#Name
        //#PlayableMainJobID-ATK-MAG-DEF-MDEF-RES-SPD
        JobMainList jobMainList = new JobMainList();
        String name;
        int id, atk, mag, def, mdef, res, spd;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();
            atk = sc.nextInt();
            mag = sc.nextInt();
            def = sc.nextInt();
            mdef = sc.nextInt();
            res = sc.nextInt();
            spd = sc.nextInt();

            //Creates new JobMainStats(atk, def, mdef, res, spd);
            JobMainStats nuJobStats = new JobMainStats(atk, def, mag, mdef, res, spd);

            //Creates new Job(name, id, JobMainStats)
            JobMainPlayable nuJobPlayable = new JobMainPlayable(name, id, nuJobStats);

            jobMainList.add(nuJobPlayable);

            //eat the rest of the line
            sc.nextLine();
        }
        return jobMainList;
    }

    JobMainList getEnemyMainJobs() {
        //#Name
        //#PlayableMainJobID-ATK-MAG-DEF-MDEF-RES-SPD
        JobMainList jobMainList = new JobMainList();
        String name;
        int id, atk, mag, def, mdef, res, spd;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();
            atk = sc.nextInt();
            mag = sc.nextInt();
            def = sc.nextInt();
            mdef = sc.nextInt();
            res = sc.nextInt();
            spd = sc.nextInt();

            //Creates new JobMainStats(atk, def, mdef, res, spd);
            JobMainStats nuJobStats = new JobMainStats(atk, def, mag, mdef, res, spd);

            //Creates new Job(name, id, JobMainStats)
            JobMainEnemy nuJobEnemy = new JobMainEnemy(name, id, nuJobStats);

            jobMainList.add(nuJobEnemy);

            //eat the rest of the line
            sc.nextLine();
        }
        return jobMainList;
    }

    JobSubList getPlayableSubJobs() {
        //#Name
        //#PlayableMainJobID-ATK-MAG-DEF-MDEF-RES-SPD
        JobSubList jobSubList = new JobSubList();
        String name;
        int id;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();

            //Creates new Job(name, id, JobMainStats)
            JobSubPlayable nuSubJobPlayable = new JobSubPlayable(name, id);

            jobSubList.add(nuSubJobPlayable);

            //eat the rest of the line
            sc.nextLine();
        }
        return jobSubList;
    }

    JobSubList getEnemySubJobs() {
        //#Name
        //#PlayableMainJobID-ATK-MAG-DEF-MDEF-RES-SPD
        JobSubList jobSubList = new JobSubList();
        String name;
        int id;

        while (sc.hasNextLine()) {
            name = sc.nextLine();
            id = sc.nextInt();

            //Creates new Job(name, id, JobMainStats)
            JobSubEnemy nuSubJobEnemy = new JobSubEnemy(name, id);

            jobSubList.add(nuSubJobEnemy);

            //eat the rest of the line
            sc.nextLine();
        }
        return jobSubList;
    }
}
