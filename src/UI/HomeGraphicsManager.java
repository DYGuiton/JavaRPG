package UI;

import java.awt.BasicStroke;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Yurichi
 */
public class HomeGraphicsManager {

    ScreenDimensions scrnDim;
    int panelButtonSpaceX, panelButtonSpaceY;
    CustomButton[] panelButtons;
    CustomButton questBoardButton;
    HomePartySidePanel theHPSP;

    Rectangle2D.Double backBar;
    HomeMunnyIcon theMunnyIcon;
    HomeGuildIcon theGuildIcon;

    int panelButtonCount;

    //GuildInventoryButton gib;
    public HomeGraphicsManager() {
        scrnDim = new ScreenDimensions();
        panelButtonCount = 5;

        setPanelButtonSpace();
        setupClickableGraphics();
        setupNonClickableGraphics();
    }

    public void paintGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.white);
        g2.fill(backBar);
//        g2.setColor(Color.CYAN);
//        g2.setStroke(new BasicStroke(3));
//        g2.draw(backBar);

        for (CustomButton panelButton : panelButtons) {
            panelButton.paint(g);
        }
        questBoardButton.paint(g);

        theMunnyIcon.paint(g);
        
        theGuildIcon.paint(g);

    }

    private void setupClickableGraphics() {
        panelButtons = new CustomButton[panelButtonCount];
        panelButtons[0] = createHomeInventoryButton(1, Color.BLUE, Color.BLACK, 3);
        panelButtons[1] = createHomeShopButton(2, Color.MAGENTA, Color.BLACK, 3);
        panelButtons[2] = createHomeGuildButton(3, Color.BLUE, Color.GRAY, Color.BLACK, 3);
        panelButtons[3] = createHomeRecordsButton(4, Color.BLUE, Color.BLACK, 3);
        panelButtons[4] = createHomeMenuButton(5, Color.GREEN, Color.BLACK, 3);

        questBoardButton = createQuestBoardButton(Color.DARK_GRAY, Color.BLACK, 3);

    }

    public void setHomePartySidePanel(HomePartySidePanel nuHPSP) {
        theHPSP = nuHPSP;
    }

    void handleHoverOver(Point2D.Double mousePosition) {
        for (int i = 0; i < panelButtons.length; i++) {
            if (panelButtons[i].contains(mousePosition)) {
                panelButtons[i].mouseOver = true;
            } else {
                panelButtons[i].mouseOver = false;
            }
        }

        if (questBoardButton.contains(mousePosition)) {
            questBoardButton.mouseOver = true;
        } else {
            questBoardButton.mouseOver = false;
        }
    }

    void handleHomePartySidePanelHoverOver(Point2D.Double mousePosition) {
        theHPSP.handleHoverOver(mousePosition);
    }

    void handleMousePressed(Point2D.Double mousePosition) {
        for (int i = 0; i < panelButtons.length; i++) {
            if (panelButtons[i].contains(mousePosition)) {
                panelButtons[i].mousePressed();
            }
        }
        if (questBoardButton.contains(mousePosition)) {
            questBoardButton.mousePressed();
        }
    }

//    private void setupNonClickableGraphics() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private void setPanelButtonSpace() {
        panelButtonSpaceX = (int) (scrnDim.getWidth() - scrnDim.getWidth() / 2.5);
        panelButtonSpaceY = scrnDim.getHeight() - scrnDim.getHeight() / 7;
    }

    private CustomButton createHomeInventoryButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount + 1));
        location.y = panelButtonSpaceY;
        return new HomeInventoryButton(location, color, outlineColor, size, scrnDim);
    }

    private CustomButton createHomeShopButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount + 1));
        location.y = panelButtonSpaceY;
        return new HomeShopButton(location, color, outlineColor, size, scrnDim);
    }

    private CustomButton createHomeGuildButton(int panelButtonIndex, Color color, Color circleColor,
            Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount + 1));
        location.y = panelButtonSpaceY;
        return new HomeGuildButton(location, color, circleColor, outlineColor, size, scrnDim);
    }

    private CustomButton createHomeRecordsButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount + 1));
        location.y = panelButtonSpaceY;
        return new HomeRecordsButton(location, color, outlineColor, size, scrnDim);
    }

    private CustomButton createHomeMenuButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount + 1));
        location.y = panelButtonSpaceY;
        return new HomeMenuButton(location, color, outlineColor, size, scrnDim);
    }

    private CustomButton createQuestBoardButton(Color color, Color nuOutlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = scrnDim.getWidth() / 2;
        location.y = panelButtonSpaceY;
        return new HomeQuestBoardButton(location, color, nuOutlineColor, size, scrnDim);
    }

    private void setupNonClickableGraphics() {
        createBackBar();
        createMunnyIcon();
        createGuildIcon();
    }

    private void createBackBar() {
        backBar = new Rectangle2D.Double();
        backBar.setRect(scrnDim.getX(), panelButtonSpaceY + scrnDim.getHeight() / 50, scrnDim.getWidth(), scrnDim.getHeight() / 50);
    }

    private void createMunnyIcon() {
        Point2D.Double location = new Point2D.Double(scrnDim.getWidth() / 8, scrnDim.getHeight() - scrnDim.getHeight() / 12);
        theMunnyIcon = new HomeMunnyIcon(location, Color.BLACK, 42, scrnDim);
    }

    public void setMunny(int munny) {
        theMunnyIcon.setMunny(munny);
    }

    private void createGuildIcon() {
        Point2D.Double location = new Point2D.Double(scrnDim.getWidth() / 50, scrnDim.getHeight() / 40);
        theGuildIcon = new HomeGuildIcon(location, Color.RED, 1, scrnDim);
    }
    
    public void setGuildName(String name){
        theGuildIcon.setGuildName(name);
    }

}
