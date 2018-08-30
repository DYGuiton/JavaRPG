package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public abstract class CustomIcon {

    public int BASESIZE = 10;
    ScreenDimensions scrnDim;
    Point2D.Double location;
    int size;
    int height, width;
    int sizeDivisor;
    Color color;

    public boolean mouseOver;

    public CustomIcon(Point2D.Double nuLocation, Color nuColor, int nuSize, ScreenDimensions nuScrnDim) {
        setLocation(nuLocation);
        setColor(nuColor);
        setSize(nuScrnDim, nuSize);//sizes: 0 - small, 1 - medium, 2 - large
        setShape();

    }

    public abstract void paint(Graphics g);

    public abstract void setShape();

    public abstract void drawShape(Graphics2D g2, int size);

    public abstract void fillShape(Graphics2D g2);

    public abstract boolean contains(Point2D.Double mousePosition);

    private void setLocation(Point2D.Double nuLocation) {
        this.location = nuLocation;
    }

    public void setColor(Color nuColor) {
        color = nuColor;
    }

    private void setSize(ScreenDimensions nuScrnDim, int nuSize) {

        scrnDim = nuScrnDim;
        size = nuSize;
        sizeDivisor = getDivisorFromSize(size);

        height = BASESIZE + scrnDim.getHeight() / sizeDivisor;
        width = BASESIZE + scrnDim.getHeight() / sizeDivisor;

    }

    private int getDivisorFromSize(int size) {
        switch (size) {
            case 0:
                return 30;
            case 1:
                return 20;
            case 2:
                return 18;
            case 3:
                return 15;
            case 4:
                return 10;
            default:
                return 15;
        }
    }

    public abstract void mouseOverAction();

    public int getSize() {
        return size;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Point2D.Double getLocation() {
        return location;
    }

    public int getX() {
        return (int) location.getX();
    }

    public int getY() {
        return (int) location.getY();
    }

}
