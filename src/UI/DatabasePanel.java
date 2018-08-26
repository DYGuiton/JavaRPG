package UI;

import UI.InterfaceFrame;
import java.awt.*;
import CharacterComponents.RPGCharacter;
import DataManagement.RPGDatabase;

/**
 *
 * @author Admin Aug 5, 2018 3:02:35 AM
 */
public class DatabasePanel extends javax.swing.JPanel {

    InterfaceFrame theInterfaceFrame;
    RPGDatabase theRPGDatabase;
    int screenWidth, screenHeight;

    public DatabasePanel(InterfaceFrame nuInterfaceFrame, RPGDatabase nuRPGDatabase) {
        initComponents();

        theRPGDatabase = nuRPGDatabase;
        theInterfaceFrame = nuInterfaceFrame;

        setupSwingComponents();
        setupGraphicComponents();
        setLayout(null);
        setVisible(true);

    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Color background = new Color(153, 102, 0);
        Color infoBackground = new Color(255, 153, 0);

        g2.setColor(Color.lightGray);

        g2.fillRect(screenWidth / 6 - 20, (screenHeight / 2) - screenHeight / 8, (int) (screenWidth / 1.5) + 50, (screenHeight / 2));

        g.setColor(infoBackground);
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke(16));

        g2.drawRect(screenWidth / 6 - 20, (screenHeight / 2) - screenHeight / 8, (int) (screenWidth / 1.5) + 50, (screenHeight / 2));

        g2.setStroke(oldStroke);
        g.fillOval(100, 100, 150, 150);            // Just checking!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openMainPanelButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        profileTA = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jobTA = new javax.swing.JTextArea();
        loadPlayableCharacterButton = new javax.swing.JButton();
        playableCharacterCB = new javax.swing.JComboBox<>();
        enemyCharacterCB = new javax.swing.JComboBox<>();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(null);

        openMainPanelButton.setText("Open Main Panel");
        openMainPanelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMainPanelButtonActionPerformed(evt);
            }
        });
        add(openMainPanelButton);
        openMainPanelButton.setBounds(10, 0, 113, 23);

        profileTA.setColumns(20);
        profileTA.setRows(5);
        jScrollPane1.setViewportView(profileTA);

        add(jScrollPane1);
        jScrollPane1.setBounds(0, 116, 166, 180);

        jobTA.setColumns(20);
        jobTA.setRows(5);
        jScrollPane2.setViewportView(jobTA);

        add(jScrollPane2);
        jScrollPane2.setBounds(230, 116, 166, 180);

        loadPlayableCharacterButton.setText("Load Playable Character Data");
        loadPlayableCharacterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadPlayableCharacterButtonActionPerformed(evt);
            }
        });
        add(loadPlayableCharacterButton);
        loadPlayableCharacterButton.setBounds(250, 10, 175, 23);

        playableCharacterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        playableCharacterCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playableCharacterCBActionPerformed(evt);
            }
        });
        add(playableCharacterCB);
        playableCharacterCB.setBounds(340, 40, 56, 20);

        enemyCharacterCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        enemyCharacterCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enemyCharacterCBActionPerformed(evt);
            }
        });
        add(enemyCharacterCB);
        enemyCharacterCB.setBounds(340, 70, 56, 20);
    }// </editor-fold>//GEN-END:initComponents

    private void openMainPanelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMainPanelButtonActionPerformed
        theInterfaceFrame.openMainMenuPanel();
    }//GEN-LAST:event_openMainPanelButtonActionPerformed

    private void loadPlayableCharacterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadPlayableCharacterButtonActionPerformed
        loadPlayableCharacter();
    }//GEN-LAST:event_loadPlayableCharacterButtonActionPerformed

    private void playableCharacterCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playableCharacterCBActionPerformed
        try {
            loadPlayableCharacter();
        } catch (Exception e) {
        }

//theRPGDatabase.getPlayableCharacterByName(playableCharacterCB.getSelectedItem().toString());
        //System.out.println(playableCharacterCB.getSelectedItem().toString());
    }//GEN-LAST:event_playableCharacterCBActionPerformed

    private void enemyCharacterCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enemyCharacterCBActionPerformed
        try {
            loadEnemyCharacter();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_enemyCharacterCBActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> enemyCharacterCB;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jobTA;
    private javax.swing.JButton loadPlayableCharacterButton;
    private javax.swing.JButton openMainPanelButton;
    private javax.swing.JComboBox<String> playableCharacterCB;
    private javax.swing.JTextArea profileTA;
    // End of variables declaration//GEN-END:variables

    private void setupSwingComponents() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        int taskBarHeight = scrnSize.height - winSize.height;

        screenWidth = tk.getScreenSize().width;
        screenHeight = tk.getScreenSize().height - taskBarHeight;

        openMainPanelButton.setBounds(10, 10, 150, 20);
        jScrollPane1.setBounds(screenWidth / 6, (screenHeight / 2) - screenHeight / 10, (screenWidth / 3), (screenHeight / 2) - 40);
        jScrollPane2.setBounds(screenWidth / 2 + 10, (screenHeight / 2) - screenHeight / 10, (screenWidth / 3), (screenHeight / 2) - 40);

        playableCharacterCB.setBounds(screenWidth - 210, jScrollPane2.getY() - 200, 200, 20);
        enemyCharacterCB.setBounds(screenWidth - 210, jScrollPane2.getY() - 150, 200, 20);

        playableCharacterCB.removeAllItems();
        enemyCharacterCB.removeAllItems();

        for (RPGCharacter nextCharacter : theRPGDatabase.getCharacterData().getPlayableCharacterList()) {
            playableCharacterCB.addItem(nextCharacter.getName());
        }
        for (RPGCharacter nextCharacter : theRPGDatabase.getCharacterData().getEnemyCharacterList()) {
            enemyCharacterCB.addItem(nextCharacter.getName());
        }

    }

    private RPGDatabase getRPGDatabase() {
        return theRPGDatabase;

    }

    private void loadPlayableCharacter() {
        //System.out.println(playableCharacterCB.getSelectedItem().toString());

        RPGCharacter currentCharacter = theRPGDatabase.getPlayableCharacterByName(playableCharacterCB.getSelectedItem().toString());

        profileTA.setText(currentCharacter.getProfile().toString());
        jobTA.setText(currentCharacter.getMainJob().toString());
        jobTA.append(currentCharacter.getSubJobs().toString());
    }

    private void loadEnemyCharacter() {
        RPGCharacter currentCharacter = theRPGDatabase.getEnemyCharacterByName(enemyCharacterCB.getSelectedItem().toString());

        profileTA.setText(currentCharacter.getProfile().toString());
        jobTA.setText(currentCharacter.getMainJob().toString());
        jobTA.append(currentCharacter.getSubJobs().toString());
    }

    public void refresh() {
        setupSwingComponents();
    }

    private void setupGraphicComponents() {

    }

}
