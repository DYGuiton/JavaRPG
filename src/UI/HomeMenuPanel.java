package UI;

import UI.InterfaceFrame;
import java.awt.*;
import java.awt.geom.Point2D;
import javax.swing.SwingUtilities;

/**
 *
 * @author Admin Aug 5, 2018 3:07:50 AM
 */
public class HomeMenuPanel extends javax.swing.JPanel {

    InterfaceFrame theInterface;
    HomeGraphicsManager theGraphicsManager;
    ScreenDimensions scrnDim;
    int x, y, width, height;

    public HomeMenuPanel(InterfaceFrame nuInterface) {
        initComponents();
        theInterface = nuInterface;
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

        characterInfoPanel = new javax.swing.JPanel();

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

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        handleMousePressed();
    }//GEN-LAST:event_formMousePressed

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        handleMouseMoved();
    }//GEN-LAST:event_formMouseMoved


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel characterInfoPanel;
    // End of variables declaration//GEN-END:variables

    private void setupSwingComponents() {
        characterInfoPanel.setBounds(scrnDim.getWidth() - scrnDim.getWidth() / 5, scrnDim.getY()+scrnDim.getHeight()/8, scrnDim.getWidth() / 5, (int) (scrnDim.getHeight() / 1.5));
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
        repaint();
    }

}
