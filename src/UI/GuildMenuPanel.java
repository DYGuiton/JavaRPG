package UI;

import UI.InterfaceFrame;
import java.awt.*;

/**
 *
 * @author Admin Aug 5, 2018 3:07:50 AM
 */
public class GuildMenuPanel extends javax.swing.JPanel {

    InterfaceFrame theInterface;
    ScreenDimensions sd;
    int x, y, width, height;

    public GuildMenuPanel(InterfaceFrame nuInterface) {
        theInterface = nuInterface;
        this.sd = new ScreenDimensions();
        initComponents();
        setupSwingComponents();
        setLayout(null);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.blue);
        g.fillOval(100, 100, 100, 100);            // Just checking!
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        openDatabaseButton = new javax.swing.JButton();
        characterInfoPanel = new javax.swing.JPanel();

        setLayout(null);

        openDatabaseButton.setText("Open Database");
        openDatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openDatabaseButtonActionPerformed(evt);
            }
        });
        add(openDatabaseButton);
        openDatabaseButton.setBounds(10, 11, 107, 23);

        characterInfoPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout characterInfoPanelLayout = new javax.swing.GroupLayout(characterInfoPanel);
        characterInfoPanel.setLayout(characterInfoPanelLayout);
        characterInfoPanelLayout.setHorizontalGroup(
            characterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        characterInfoPanelLayout.setVerticalGroup(
            characterInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 238, Short.MAX_VALUE)
        );

        add(characterInfoPanel);
        characterInfoPanel.setBounds(290, 0, 110, 240);
    }// </editor-fold>//GEN-END:initComponents

    private void openDatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openDatabaseButtonActionPerformed
        theInterface.openDatabasePanel();
    }//GEN-LAST:event_openDatabaseButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel characterInfoPanel;
    private javax.swing.JButton openDatabaseButton;
    // End of variables declaration//GEN-END:variables

    private void setupSwingComponents() {


    }

}
