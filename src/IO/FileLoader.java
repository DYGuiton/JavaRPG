package IO;

import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import DataManagement.JobMainList;
import DataManagement.JobSubList;
import DataManagement.ProfileList;

/**
 * @author Yurichi
 */
public class FileLoader {

    private FileReader theFileReader = new FileReader();
    String path;

    public FileLoader() {
        openFile(getFileName());
    }

    public FileLoader(String filename) {
        theFileReader.openFile(filename);
    }

    public void openFile(String filename) {
        theFileReader.openFile(filename);

    }

    public void closeFile() {
        theFileReader.closeFile();
    }

    private String getFileName() {
        FileDialog fd = new FileDialog(new Frame(), "Select Input File");
        fd.setFile("input");
        fd.setVisible(true);
        path = fd.getDirectory() + fd.getFile();
        return path;
    }

    public ProfileList loadPlayableProfiles() {
        return theFileReader.getPlayableProfiles();
    }

    public ProfileList loadEnemyProfiles() {
        return theFileReader.getEnemyProfiles();
    }

    public JobMainList loadPlayableMainJobs() {
        return theFileReader.getPlayableMainJobs();
    }

    public JobMainList loadEnemyMainJobs() {
        return theFileReader.getEnemyMainJobs();
    }

    public JobSubList loadPlayableSubJobs() {
        return theFileReader.getPlayableSubJobs();
    }

    public JobSubList loadEnemySubJobs() {
        return theFileReader.getEnemySubJobs();
    }
}
