package UI;

import java.awt.*;
import java.awt.geom.Point2D;
import javarpg.Guild;
import javarpg.PlayerParty;

/**
 *
 * @author Admin Sep 2, 2018 1:02:45 AM
 */
public class HomePartySidePanel extends javax.swing.JPanel {

    Guild playerGuild;
    int x, y, width, height;
    CharacterDisplay[] theCDs = new CharacterDisplay[4];

    public HomePartySidePanel(Guild nuGuild) {
        initComponents();
        setLayout(null);
        setVisible(true);
        playerGuild = nuGuild;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCharacterDisplays(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void setDimensions() {
        x = (int) this.getBounds().getX();
        y = (int) this.getBounds().getY();
        width = (int) this.getBounds().getWidth();
        height = (int) this.getBounds().getHeight();
    }

    public void setCharacterDisplays() {
        PlayerParty myParty = (PlayerParty) playerGuild.getParty();
        for (int i = 0; i < myParty.getSize(); i++) {
            CharacterDisplay cd = new CharacterDisplay();
            cd.setBounds(x, y, 0, ((height / 4) * i), width, height / 4);
            cd.setCharacter(myParty.getCharacter(i));
            theCDs[i] = cd;
        }
    }

    private void drawCharacterDisplays(Graphics g) {
        for (int i = 0; i < theCDs.length; i++) {
            if (theCDs[i] != null) {
                theCDs[i].paint(g);
            }
        }
    }

    void handleHoverOver(Point2D.Double mousePosition) {
        for (int i = 0; i < theCDs.length; i++) {
            if(theCDs[i].contains(mousePosition)){
                theCDs[i].setMouseOver(true);
            } else {
                theCDs[i].setMouseOver(false);
                System.out.println("twas false");
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
