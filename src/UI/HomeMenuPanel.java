package UI;

import UI.InterfaceFrame;
import java.awt.*;
import java.awt.geom.Point2D;
import javarpg.GameManager;
import javax.swing.BorderFactory;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin Aug 5, 2018 3:07:50 AM
 */
public class HomeMenuPanel extends javax.swing.JPanel {

    GameManager theGameManager;
    InterfaceFrame theInterface;
    HomeGraphicsManager theGraphicsManager;
    HomePartySidePanel theHPSP;
    ScreenDimensions scrnDim;
    int x, y, width, height;

    public HomeMenuPanel(InterfaceFrame nuInterface, GameManager nuGameManager) {
        initComponents();
        theInterface = nuInterface;
        theGameManager = nuGameManager;
        this.scrnDim = new ScreenDimensions();
        theGraphicsManager = new HomeGraphicsManager();

        setupSwingComponents();
        setLayout(null);
        setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        //sets smooth stroke!
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        //sets smooth stroke!
        Font font = new Font("Palatino Linotype", Font.BOLD, 12);
        g2.setFont(font);
        theGraphicsManager.paintGraphics(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });
        setLayout(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        handleMousePressed();
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        handleMouseMoved();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
    private void setupSwingComponents() {
        theHPSP = new HomePartySidePanel(theGameManager.getUserManager().getGuild());
        this.add(theHPSP);
        theHPSP.setBorder(BorderFactory.createLineBorder(Color.black));
        theHPSP.setBounds(scrnDim.getWidth() - scrnDim.getWidth() / 5, scrnDim.getY() + scrnDim.getHeight() / 8,
                scrnDim.getWidth() / 5, (int) (scrnDim.getHeight() / 1.5));
        theHPSP.setDimensions();
        theHPSP.setCharacterDisplays();
        theGraphicsManager.setHomePartySidePanel(theHPSP);
    }

    private void handleMousePressed() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, this);
        double x = p.getX();
        double y = p.getY();

        Point2D.Double mousePosition = new Point2D.Double(x, y);

        checkIconPressed(mousePosition);
    }

    private void handleMouseMoved() {
        Point p = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(p, this);
        double x = p.getX();
        double y = p.getY();

        Point2D.Double mousePosition = new Point2D.Double(x, y);

        checkIconHoverOver(mousePosition);
    }

    private void checkIconPressed(Point2D.Double mousePosition) {
        theGraphicsManager.handlePlayerCharacterMousePressed(mousePosition);
        repaint();
    }

    private void checkIconHoverOver(Point2D.Double mousePosition) {
        theGraphicsManager.handlePlayerCharacterHoverOver(mousePosition);
        theGraphicsManager.handleHomePartySidePanelHoverOver(mousePosition);
        repaint();
    }

}
