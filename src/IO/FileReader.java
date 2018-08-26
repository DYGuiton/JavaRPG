package IO;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import DataManagement.JobMainList;
import DataManagement.JobSubList;
import DataManagement.ProfileList;

/**
 * @author Yurichi
 */
class FileReader {

    private Scanner sc;

    public void openFile(String filename) {
        
        try {
            sc = new Scanner(new File(filename));
        } catch (Exception e) {
            System.out.println("File Not Found.");
        }
    }

    public void closeFile() {
        sc.close();
    }

    public ProfileList getPlayableProfiles() {
        if (sc.nextInt() == 0) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Sub Jobs Indentifier Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getPlayableProfiles();

        }
        return null;
    }

    public ProfileList getEnemyProfiles() {
        if (sc.nextInt() == 1) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Sub Jobs Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getEnemyProfiles();

        }
        return null;
    }

    public JobMainList getPlayableMainJobs() {
        if (sc.nextInt() == 2) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getPlayableMainJobs();

        }
        return null;
    }

    public JobMainList getEnemyMainJobs() {
        if (sc.nextInt() == 3) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getEnemyMainJobs();

        }
        return null;
    }

    public JobSubList getPlayableSubJobs() {
        if (sc.nextInt() == 4) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getPlayableSubJobs();

        }
        return null;
    }

    public JobSubList getEnemySubJobs() {
        if (sc.nextInt() == 5) {
            //Move us down the identifier lines in the Playable Profile Text File
            sc.nextLine();//File ID line
            sc.nextLine();//Name Identifier Line
            sc.nextLine();//Variable Identifier Line
            sc.nextLine();//Separator Line

            FileDataHandler theFDH = new FileDataHandler(sc);
            return theFDH.getEnemySubJobs();

        }
        return null;
    }
}
