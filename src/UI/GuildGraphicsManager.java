package UI;

import java.awt.geom.Point2D;
import java.awt.Color;
import java.awt.Graphics;

/**
 * @author Yurichi
 */
public class GuildGraphicsManager {

    ScreenDimensions scrnDim;
    int panelButtonSpaceX, panelButtonSpaceY;
    CustomButton[] panelButtons;
    int panelButtonCount;

    //GuildInventoryButton gib;
    public GuildGraphicsManager() {
        scrnDim = new ScreenDimensions();
        panelButtonCount = 5;

        setPanelButtonSpace();
        setupClickableGraphics();
        //setupNonClickableGraphics();
    }

    public void paintGraphics(Graphics g) {
        for (CustomButton panelButton : panelButtons) {
            panelButton.paint(g);
        }
    }

    private void setupClickableGraphics() {
        panelButtons = new CustomButton[panelButtonCount];
        panelButtons[0] = createGuildInventoryButton(1, Color.BLUE, Color.BLACK, 3);
        panelButtons[1] = createGuildShopButton(2, Color.BLUE, Color.BLACK, 3);
        panelButtons[2] = createGuildInventoryButton(3, Color.BLUE, Color.BLACK, 3);
        panelButtons[3] = createGuildInventoryButton(4, Color.BLUE, Color.BLACK, 3);
        panelButtons[4] = createGuildInventoryButton(5, Color.BLUE, Color.BLACK, 3);

    }

    void handlePlayerCharacterHoverOver(Point2D.Double mousePosition) {
        for (int i = 0; i < panelButtons.length; i++) {
            if (panelButtons[i].contains(mousePosition)) {
                panelButtons[i].mouseOver = true;
            } else {
                panelButtons[i].mouseOver = false;
            }
        }
    }

    void handlePlayerCharacterMousePressed(Point2D.Double mousePosition) {
        for (int i = 0; i < panelButtons.length; i++) {
            if (panelButtons[i].contains(mousePosition)) {
                panelButtons[i].mousePressed();
            }
        }
    }

//    private void setupNonClickableGraphics() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    private void setPanelButtonSpace() {
        panelButtonSpaceX = (int)(scrnDim.getWidth() - scrnDim.getWidth() / 2.5);
        System.out.println(panelButtonSpaceX);
        panelButtonSpaceY = scrnDim.getHeight() - scrnDim.getHeight() / 7;
    }

    private CustomButton createGuildInventoryButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount+1));
        location.y = panelButtonSpaceY;
        return new GuildInventoryButton(location, color, outlineColor, size, scrnDim);
    }

    private CustomButton createGuildShopButton(int panelButtonIndex, Color color, Color outlineColor, int size) {
        Point2D.Double location = new Point2D.Double();
        location.x = panelButtonSpaceX + panelButtonIndex * ((scrnDim.getWidth() - panelButtonSpaceX) / (panelButtonCount+1));
        location.y = panelButtonSpaceY;
        return new GuildShopButton(location, color, outlineColor, size, scrnDim);
    }

}
