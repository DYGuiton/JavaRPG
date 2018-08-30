package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public class HomeShopButton extends CustomButton {

    Polygon shape, outline;

    public HomeShopButton(Point2D.Double location, Color color, Color nuOutlineColor, int size, ScreenDimensions scrnDim) {
        super(location, color, size, scrnDim);
        outlineColor = nuOutlineColor;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        fillShape(g2);
        if (mouseOver) {
            g.setColor(color);
            drawShape(g2, 2);
            g.setColor(outlineColor);
            drawOutline(g2, 3);
            g2.setColor(Color.ORANGE);
            g2.drawString("Shop", (int) (location.x + scrnDim.getWidth() / 80), (int) (location.y + scrnDim.getHeight() / 10));
        } else {
            g2.setColor(Color.BLACK);
            g2.drawString("Shop", (int) (location.x + scrnDim.getWidth() / 80), (int) (location.y + scrnDim.getHeight() / 10));
        }
    }

    @Override
    public void mousePressed() {
        System.out.println("Button Pressed");
        //further implementation later    
    }

    @Override
    public void setShape() {

        int[] xPoints = createPentagonXPoints(0);
        int[] yPoints = createPentagonYPoints(0);
        shape = new Polygon(xPoints, yPoints, 5);

        xPoints = createPentagonXPoints(2);
        yPoints = createPentagonYPoints(2);
        outline = new Polygon(xPoints, yPoints, 6);
    }

    @Override
    public void drawShape(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(size));
        g2.setColor(color);
        g2.draw(shape);
        g2.setStroke(new BasicStroke(2));
    }

    @Override
    public void fillShape(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(shape);
    }

    @Override
    public void drawOutline(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(size));
        g2.setColor(outlineColor);
        g2.draw(outline);
        g2.setStroke(new BasicStroke(2));
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return shape.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
        mouseOver = true;
    }

    private int[] createPentagonXPoints(int outlineVal) {
        //int divisor = getDivisorFromSize();

        int x0 = (int) location.x - outlineVal;
        int x1 = (int) location.x + scrnDim.getWidth() / 45;
        int x2 = (int) x1 + scrnDim.getWidth() / 45 + outlineVal;
        int x3 = (int) x1 + scrnDim.getWidth() / 55 + outlineVal;
        int x4 = (int) x1 - scrnDim.getWidth() / 55 - outlineVal;

        int[] xPoints = {x0, x1, x2, x3, x4, x0};

        return xPoints;
    }

    private int[] createPentagonYPoints(int outlineVal) {
        int y0 = (int) (location.y + scrnDim.getWidth() / 55);
        int y1 = (int) location.y - outlineVal;
        int y2 = y0;
        int y3 = y0 + scrnDim.getWidth() / 45 + outlineVal;
        int y4 = y3;
        int y5 = y0;

        int[] yPoints = {y0, y1, y2, y3, y4, y5};
        return yPoints;
    }

}
