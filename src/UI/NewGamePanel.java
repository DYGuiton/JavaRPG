package UI;

import CharacterComponents.*;
import DataManagement.RPGDatabase;
import UI.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.geom.Rectangle2D;
import javarpg.GameManager;

/**
 *
 * @author Admin Aug 20, 2018 5:50:34 PM
 */
public class NewGamePanel extends javax.swing.JPanel {

    InterfaceFrame theInterfaceFrame;
    RPGDatabase theRPGDatabase;
    GameManager theGameManager;
    RPGCharacterUser theMainCharacter;
    ScreenDimensions scrnDim;

    public NewGamePanel(InterfaceFrame theInterfaceFrame, GameManager theGameManager) {
        initComponents();
        setLayout(null);
        setVisible(true);
        this.theInterfaceFrame = theInterfaceFrame;
        this.theGameManager = theGameManager;
        this.theRPGDatabase = theGameManager.getRPGDatabase();
        

        setupSwingComponents();

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        int[] x = {550, 550, 590, 590, 650, 590, 590};
        int[] y = {55, 85, 85, 110, 70, 30, 55};
        g.fillPolygon(x, y, 7);

        //g.fillOval(100, 100, 100, 100);            // Just checking!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        titleLabel = new javax.swing.JLabel();
        nameLabel = new javax.swing.JLabel();
        nameTF = new javax.swing.JTextField();
        genderLabel = new javax.swing.JLabel();
        jobLabel = new javax.swing.JLabel();
        jobTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        descTA = new javax.swing.JTextArea();
        confirmButton = new javax.swing.JButton();
        genderCB = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jobList = new javax.swing.JList<>();

        jButton1.setText("jButton1");

        titleLabel.setText("Create Character");

        nameLabel.setFont(new java.awt.Font("Palatino Linotype", 0, 11)); // NOI18N
        nameLabel.setText("Name");
        nameLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        nameTF.setText("Input Name Here...");
        nameTF.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nameTFMousePressed(evt);
            }
        });
        nameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameTFActionPerformed(evt);
            }
        });

        genderLabel.setFont(new java.awt.Font("Palatino Linotype", 0, 11)); // NOI18N
        genderLabel.setText("Gender");
        genderLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jobLabel.setFont(new java.awt.Font("Palatino Linotype", 0, 11)); // NOI18N
        jobLabel.setText("Job");
        jobLabel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jobTF.setEditable(false);
        jobTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jobTFActionPerformed(evt);
            }
        });

        descTA.setEditable(false);
        descTA.setColumns(20);
        descTA.setRows(5);
        descTA.setText("...");
        jScrollPane1.setViewportView(descTA);

        confirmButton.setText("Confirm Character");
        confirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmButtonActionPerformed(evt);
            }
        });

        genderCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jobList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jobList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jobListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(jobList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(titleLabel)
                        .addGap(0, 306, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jobLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jobTF, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(genderLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(nameTF, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(genderCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(18, 18, 18)
                        .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel)
                            .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(genderLabel)
                            .addComponent(genderCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jobLabel)
                            .addComponent(jobTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(confirmButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addGap(18, 18, 18))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void nameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameTFActionPerformed

    private void jobTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jobTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jobTFActionPerformed

    private void confirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmButtonActionPerformed
        GenerateUserCharacter();
    }//GEN-LAST:event_confirmButtonActionPerformed

    private void nameTFMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nameTFMousePressed
        nameTF.selectAll();
    }//GEN-LAST:event_nameTFMousePressed

    private void jobListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jobListValueChanged
        jobTF.setText(jobList.getSelectedValue());
        descTA.setText(getJobDescription(jobTF.getText()));
    }//GEN-LAST:event_jobListValueChanged

    private void GenerateUserCharacter() {

        if ("Input Name Here...".equals(nameTF.getText())) {
            descTA.setText("Enter your name.");
        } else if ("".equals(nameTF.getText())) {
            descTA.setText("Enter your name.");
        } else if ("".equals(jobTF.getText())) {
            descTA.setText("Select a job.");
        } else if (JOptionPane.showConfirmDialog(this, "Confirm your Character?", "Confirmation", 0) == 0) {

            String name = ChooseName();
            int gender = ChooseGender((String) genderCB.getSelectedItem());
            int startingJobID = ChooseJobMain(jobTF.getText());

            ProfileStats userProfileStats = new ProfileStats(1, 10, 0, 1, 1);

            ArrayList<Integer> subJobIDs = new ArrayList<>();
            subJobIDs.add(0);

            ProfilePlayable userProfile = new ProfilePlayable(name, 0, gender,
                    startingJobID, userProfileStats, subJobIDs);

            JobMainPlayable userMainJob = (JobMainPlayable) theRPGDatabase.getCharacterData()
                    .getJobMainData().getJobPlayableById(userProfile.getMainJobId());

            PlayableSubJobContainer userSubJobContainer = new PlayableSubJobContainer(userProfile.
                    getLearnedSubJobIds(), theRPGDatabase.getCharacterData().getJobSubData());

            RPGCharacterPlayable MainCharacter = new RPGCharacterPlayable((ProfilePlayable) userProfile,
                    userMainJob, userSubJobContainer, true);

            theRPGDatabase.getCharacterData().storePlayableCharacter(MainCharacter);
            theGameManager.createUserManager();

            theInterfaceFrame.theGame.startNewGame();

        }
    }

    private String ChooseName() {
        if ("".equals(nameTF.getText())) {
            return "Default";
        }
        return nameTF.getText();
    }

    private int ChooseGender(String gender) {
        switch (gender) {
            case "Female":
                return 0;
            case "Male":
                return 1;
            case "Non-Binary":
                return 2;
            default:
                return 2;
        }
    }

    private int ChooseJobMain(String job) {
        switch (job) {
            case "Warrior":
                return 0;
            case "Magus":
                return 1;
            case "Ranger":
                return 2;
            default:
                return 0;
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton confirmButton;
    private javax.swing.JTextArea descTA;
    private javax.swing.JComboBox<String> genderCB;
    private javax.swing.JLabel genderLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jobLabel;
    private javax.swing.JList<String> jobList;
    private javax.swing.JTextField jobTF;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTF;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables

    private void setupSwingComponents() {
        setupScreenDimensions();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fontNames = ge.getAvailableFontFamilyNames();
//        for (String fontName : fontNames) {
//            System.out.println(fontName);
//        }
        Font oldFont = this.getFont();
        Font labelFont = new Font("Palatino Linotype", Font.BOLD + Font.ITALIC, 20);

        JLabel[] labels = new JLabel[]{nameLabel, genderLabel, jobLabel};
        for (int i = 0; i < labels.length; i++) {
            labels[i].setFont(labelFont);
            labels[i].setBounds(scrnDim.getWidth() / 20, scrnDim.getHeight() / 10 + (i * (scrnDim.getHeight() / 20)),
                    (int) (scrnDim.getWidth() / 13.5), scrnDim.getHeight() / 20);
        }

        Font typeFont = new Font("Helvetica", Font.PLAIN, 18);
        nameTF.setFont(typeFont);
        nameTF.setBounds(scrnDim.getWidth() / 8, scrnDim.getHeight() / 10, scrnDim.getWidth() / 5, scrnDim.getHeight() / 20);

        genderCB.setFont(typeFont);
        genderCB.removeAllItems();
        genderCB.addItem("Female");
        genderCB.addItem("Male");
        genderCB.addItem("Non-Binary");

        genderCB.setBounds(scrnDim.getWidth() / 8, scrnDim.getHeight() / 10 + (1 * (scrnDim.getHeight() / 20)),
                scrnDim.getWidth() / 5, scrnDim.getHeight() / 20);

        jobTF.setFont(typeFont);
        jobTF.setBounds(scrnDim.getWidth() / 8, scrnDim.getHeight() / 10 + (2 * (scrnDim.getHeight() / 20)),
                scrnDim.getWidth() / 5, scrnDim.getHeight() / 20);

        String[] jobNames = new String[]{"Warrior", "Magus", "Ranger"};

        jobList.setListData(jobNames);
        jobList.setVisibleRowCount(3);
        jobList.setFixedCellHeight((int) (scrnDim.getHeight() / 6.05));
        jobList.setFont(new Font("Helvetica", Font.BOLD + Font.ITALIC, 24));
        jScrollPane2.setBounds(scrnDim.getWidth() / 20, scrnDim.getHeight() / 4, (int) (scrnDim.getWidth() / 3.65), scrnDim.getHeight() / 2);

        descTA.setFont(new Font("Palatino Linotype", Font.BOLD + Font.ITALIC, 24));
        jScrollPane1.setBounds(scrnDim.getWidth() / 3, scrnDim.getHeight() / 4, scrnDim.getWidth() / 2, scrnDim.getHeight() / 2);

        confirmButton.setBounds(scrnDim.getWidth() - scrnDim.getWidth() / 3, scrnDim.getHeight() / 10 + (scrnDim.getWidth() / 20),
                (int) (scrnDim.getWidth() / 6), scrnDim.getHeight() / 20
        );
    }

    private void setupScreenDimensions() {
        scrnDim = new ScreenDimensions();
    }

    private String getJobDescription(String job) {
        switch (job) {
            case "Warrior":
                return "The power of the warrior.\n\nInvincible courage.\n\nBringer of destruction.";
            case "Magus":
                return "The power of the Magus.\n\nInner strength.\n\nA mystic of wonder and ruin.";
            case "Ranger":
                return "The power of the Ranger.\n\nSkillful potency.\n\nThe kindness to aid friends.";
            default:
                return "The power of the warrior.\n\nInvincible courage.\n\nBringer of destruction.";
        }
    }

}
