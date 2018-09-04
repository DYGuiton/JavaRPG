package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public class HomeMunnyIcon extends CustomIcon {

    String[] munnyString;

    public HomeMunnyIcon(Point2D.Double nuLocation, Color nuColor, int nuSize, ScreenDimensions nuScrnDim) {
        super(nuLocation, nuColor, nuSize, nuScrnDim);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawShape(g2, size);
    }

    @Override
    public void setShape() {
        munnyString = new String[2];
        munnyString[0] = "Munny: ";
        munnyString[1] = "0";
    }

    @Override
    public void drawShape(Graphics2D g2, int size) {
        String wholeString = munnyString[0] + munnyString[1];
        g2.setColor(color);
        g2.setFont(new Font("Impact", Font.BOLD, size));
        g2.drawString(wholeString, (int) location.x, (int) location.y);
    }

    @Override
    public void fillShape(Graphics2D g2) {
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return false;
    }

    @Override
    public void mouseOverAction() {
    }

    public void setMunny(int nuMunny) {
        munnyString[1] = "" + nuMunny;
    }

}
