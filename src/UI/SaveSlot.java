package UI;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Scanner;
import javarpg.Game;
import javarpg.GameManager;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * @author Yurichi
 */
class SaveSlot implements Serializable {

    MainMenuPanel theMenuPanel;

    JButton loadButton;
    JTextField saveNameTF;
    JButton deleteButton;
    String saveFilePath;
    ScreenDimensions scrnDim = new ScreenDimensions();
    

    private int slotIndex;
    private String saveName;
    GameManager savedGameManager;
    
    boolean containsSave;

    SaveSlot(JButton loadButton, JTextField saveName, JButton deleteSlot, MainMenuPanel theMenu, int slotIndex) {
        this.loadButton = loadButton;
        this.saveNameTF = saveName;
        this.deleteButton = deleteSlot;
        this.theMenuPanel = theMenu;
        this.slotIndex = slotIndex;
        containsSave = checkContainsSave();

    }

    public void setSaveSlotDisplay() {
        createLoadButton((float) slotIndex);
        createSaveTextField((float) slotIndex);
        createDeleteButton((float) slotIndex);

    }

    public void setVisible(boolean visible) {
        loadButton.setVisible(visible);
        saveNameTF.setVisible(visible);
        deleteButton.setVisible(visible);
    }

    private void createLoadButton(float index) {
        loadButton.setBounds((int) (scrnDim.getWidth() * 0.325), (int) (scrnDim.getHeight() * (0.6 + (index / 10))),
                (int) (scrnDim.getWidth() * 0.06), (int) (scrnDim.getHeight() * 0.05));
        loadButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                switch (loadButtonActionPerformed(evt)) {
                    case 0:
                        theMenuPanel.startNewGame();
                        break;
                    case 1:
                        theMenuPanel.startGame(savedGameManager);
                        break;
                    case 2:
                        System.out.println("Something went wrong starting the game!");
                        break;
                    default:
                        System.out.println("Something went wrong starting the game!");
                        break;
                }

            }
        });
    }

    private void createSaveTextField(float index) {
        saveNameTF.setBounds((int) (scrnDim.getWidth() * 0.4), (int) (scrnDim.getHeight() * (0.6 + (index / 10))),
                (int) (scrnDim.getWidth() * 0.2), (int) (scrnDim.getHeight() * 0.05));

        if (checkContainsSave()) {
            saveNameTF.setText(getSaveName());
            saveNameTF.setEditable(false);
        }

    }

    private void createDeleteButton(float index) {
        deleteButton.setBounds((int) (scrnDim.getWidth() * 0.625), (int) (scrnDim.getHeight() * (0.6 + (index / 10))),
                (int) (scrnDim.getWidth() * 0.04), (int) (scrnDim.getHeight() * 0.05));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
    }

    private int loadButtonActionPerformed(ActionEvent evt) {
        //String fileName = "SaveData/SavePackage/save" + slotIndex + ".bin";
        
        if (containsSave) {//load the save
            String fileName = "SaveData/SavePackage/" + saveNameTF.getText() + "-save" + slotIndex + ".bin";
            //System.out.println("Hello we're gonna load here");
            try {
                ObjectInputStream is = new ObjectInputStream(new FileInputStream(fileName));
                savedGameManager = (GameManager) is.readObject();

                //System.out.println(savedGameManager.toString());
                is.close();
                return 1;//1 stands for starting a loaded game
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {//Make a new save
            String fileName = "SaveData/SavePackage/" + saveNameTF.getText() + "-save" + slotIndex + ".bin";
            GameManager nuGameManager = new GameManager(theMenuPanel.theInterface.theGame);
            try {
                ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(fileName));
                os.writeObject(nuGameManager);
                os.close();
                containsSave = checkContainsSave();
                saveNameTF.setEditable(false);
                return 0;//0 stands for stating a brand new game

            } catch (Exception e) {
                e.printStackTrace();
            }

            //System.out.println("Done Writing");
        }

        return 2;//2 stands for do nothing cuz nothing got loaded and something went wrong
    }

    private boolean deleteButtonActionPerformed(ActionEvent evt) {
        File file = new File("SaveData/SavePackage/" + saveNameTF.getText() + "-save" + slotIndex + ".bin");

        if (JOptionPane.showConfirmDialog(theMenuPanel, "Delete Save File?", "Confirmation", 0) == 0) {
            if (file.delete()) {
                containsSave = checkContainsSave();
                saveNameTF.setText("");
                saveNameTF.setEditable(true);
                return !containsSave;

            }
        }

        return containsSave;

    }

    private boolean checkContainsSave() {

        File folder = new File("SaveData/SavePackage");
        File[] listOfFiles = folder.listFiles();

        for (File nextFile : listOfFiles) {
            if (nextFile.exists()) {
                String fileName = nextFile.getName();
                String[] fileNameArray = fileName.split("-", 2);

                if (fileNameArray[1].equals("save" + slotIndex + ".bin")) {
                    return true;
                }
            }

            return false;
        }

        return false;

    }

    private String getSaveName() {
        File folder = new File("SaveData/SavePackage");
        File[] listOfFiles = folder.listFiles();

        for (File nextFile : listOfFiles) {
            if (nextFile.exists()) {
                String fileName = nextFile.getName();
                String[] fileNameArray = fileName.split("-", 2);

                if (fileNameArray[1].equals("save" + slotIndex + ".bin")) {
                    return fileNameArray[0];
                }
            }

            return "empty";
        }

        return "empty";
    }
}
