package UI;

import java.awt.*;
import java.io.File;
import javarpg.GameManager;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Admin Aug 16, 2018 8:17:22 PM
 */
public class MainMenuPanel extends javax.swing.JPanel {

    InterfaceFrame theInterface;
    ScreenDimensions scrnDim;
    SaveSlot[] theSaveSlots;
    int x, y, width, height;

    public MainMenuPanel(InterfaceFrame nuInterface) {
        initComponents();
        setupSwingComponents();
        setLayout(null);
        setVisible(true);
        theInterface = nuInterface;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(100, 100, 100, 100);            // Just checking!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        campaignButton = new javax.swing.JButton();
        slotButton1 = new javax.swing.JButton();
        saveName1 = new javax.swing.JTextField();
        slotButton2 = new javax.swing.JButton();
        saveName2 = new javax.swing.JTextField();
        slotButton3 = new javax.swing.JButton();
        saveName3 = new javax.swing.JTextField();
        deleteSlotButton3 = new javax.swing.JButton();
        deleteSlotButton1 = new javax.swing.JButton();
        deleteSlotButton2 = new javax.swing.JButton();

        setLayout(null);

        campaignButton.setFont(new java.awt.Font("Palatino Linotype", 1, 24)); // NOI18N
        campaignButton.setText("Start");
        campaignButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campaignButtonActionPerformed(evt);
            }
        });
        add(campaignButton);
        campaignButton.setBounds(140, 200, 110, 41);

        slotButton1.setText("Slot 1");
        slotButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotButton1ActionPerformed(evt);
            }
        });
        add(slotButton1);
        slotButton1.setBounds(50, 190, 59, 23);

        saveName1.setText("jTextField1");
        add(saveName1);
        saveName1.setBounds(130, 190, 130, 20);

        slotButton2.setText("Slot 2");
        slotButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotButton2ActionPerformed(evt);
            }
        });
        add(slotButton2);
        slotButton2.setBounds(50, 220, 59, 23);

        saveName2.setText("jTextField1");
        add(saveName2);
        saveName2.setBounds(130, 220, 130, 20);

        slotButton3.setText("Slot 3");
        slotButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                slotButton3ActionPerformed(evt);
            }
        });
        add(slotButton3);
        slotButton3.setBounds(50, 250, 59, 23);

        saveName3.setText("jTextField1");
        add(saveName3);
        saveName3.setBounds(130, 250, 130, 20);

        deleteSlotButton3.setText("X");
        add(deleteSlotButton3);
        deleteSlotButton3.setBounds(270, 250, 40, 23);

        deleteSlotButton1.setText("X");
        add(deleteSlotButton1);
        deleteSlotButton1.setBounds(270, 190, 39, 23);

        deleteSlotButton2.setText("X");
        add(deleteSlotButton2);
        deleteSlotButton2.setBounds(270, 220, 40, 23);
    }// </editor-fold>//GEN-END:initComponents

    private void campaignButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campaignButtonActionPerformed
        File folder = new File("SaveData/SavePackage");
        File[] listOfFiles = folder.listFiles();

        if (listOfFiles.length < 1) {
            startNewGame();
        } else {
            campaignButton.setVisible(false);
            setSaveSlotsVisible(true);
        }
    }//GEN-LAST:event_campaignButtonActionPerformed

    private void slotButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slotButton1ActionPerformed

    private void slotButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slotButton2ActionPerformed

    private void slotButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_slotButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_slotButton3ActionPerformed

    private void setupSwingComponents() {
        setupScreenDimensions();
        setupStartButton();
        setupSaveSlots();

    }

    private void setupScreenDimensions() {
        scrnDim = new ScreenDimensions();

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton campaignButton;
    private javax.swing.JButton deleteSlotButton1;
    private javax.swing.JButton deleteSlotButton2;
    private javax.swing.JButton deleteSlotButton3;
    private javax.swing.JTextField saveName1;
    private javax.swing.JTextField saveName2;
    private javax.swing.JTextField saveName3;
    private javax.swing.JButton slotButton1;
    private javax.swing.JButton slotButton2;
    private javax.swing.JButton slotButton3;
    // End of variables declaration//GEN-END:variables

    private void setupStartButton() {
        campaignButton.setOpaque(false);
        campaignButton.setContentAreaFilled(false); //to make the content area transparent
        //campaignButton.setBorderPainted(false); //to make the borders transparent
        campaignButton.setBounds((int) (scrnDim.getWidth() * 0.4), (int) (scrnDim.getHeight() * 0.8),
                (int) (scrnDim.getWidth() * 0.2), (int) (scrnDim.getHeight() * 0.05));
        campaignButton.getModel().addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(ChangeEvent e) {
                if (campaignButton.getModel().isRollover()) {
                    //Font font = new Font("Serrif", Font.UNDERLINE, 12);
                    campaignButton.setForeground(Color.orange);
                } else {
                    campaignButton.setForeground(Color.black);
                }
            }
        });
    }

    private void setupSaveSlots() {
        SaveSlot saveSlot0 = new SaveSlot(slotButton1, saveName1, deleteSlotButton1, this, 0);
        SaveSlot saveSlot1 = new SaveSlot(slotButton2, saveName2, deleteSlotButton2, this, 1);
        SaveSlot saveSlot2 = new SaveSlot(slotButton3, saveName3, deleteSlotButton3, this, 2);

        theSaveSlots = new SaveSlot[]{saveSlot0, saveSlot1, saveSlot2};
        for (int i = 0; i < theSaveSlots.length; i++) {
            theSaveSlots[i].setSaveSlotDisplay();
            theSaveSlots[i].setVisible(false);
        }
    }

    private void setSaveSlotsVisible(boolean visible) {
        for (SaveSlot theSaveSlot : theSaveSlots) {
            theSaveSlot.setVisible(visible);
        }
    }

    void startNewGame() {
        theInterface.theGame.createNewGame();
    }

    void startGame(GameManager savedGameManager) {
        theInterface.theGame.startGame(savedGameManager);
    }
}
