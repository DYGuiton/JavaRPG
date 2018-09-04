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
public class HomeMenuButton extends CustomButton {

    Polygon shape, outline;

    public HomeMenuButton(Point2D.Double location, Color color, Color nuOutlineColor, int size, ScreenDimensions scrnDim) {
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
            g2.drawString("Menu", (int) (location.x + scrnDim.getWidth() / 90), (int) (location.y + scrnDim.getHeight() / 10));
        } else {
            g2.setColor(Color.BLACK);
            g2.drawString("Menu", (int) (location.x + scrnDim.getWidth() / 90), (int) (location.y + scrnDim.getHeight() / 10));
        }
    }

    @Override
    public boolean mousePressed() {
        System.out.println("Button Pressed");
        //further implementation later  
    }

    @Override
    public void drawOutline(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(size));
        g2.setColor(outlineColor);
        g2.draw(outline);
        g2.setStroke(new BasicStroke(2));
    }

    @Override
    public void setShape() {
        int[] xPoints = createOctogonXPoints(0);
        int[] yPoints = createOctogonYPoints(0);
        shape = new Polygon(xPoints, yPoints, 9);

        xPoints = createOctogonXPoints(2);
        yPoints = createOctogonYPoints(2);
        outline = new Polygon(xPoints, yPoints, 9);

    }

    @Override
    public void drawShape(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(size));
        g2.setColor(color);
        g2.draw(shape);
    }

    @Override
    public void fillShape(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(shape);
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return shape.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
        mouseOver = true;
    }

    private int[] createOctogonXPoints(int outlineValue) {
        int x0 = (int) location.x - outlineValue;
        int x1 = (int) location.x + scrnDim.getWidth() / 80 - outlineValue;
        int x2 = (int) location.x + scrnDim.getWidth() / 80 + scrnDim.getWidth() / 50 + outlineValue;
        int x3 = (int) x2 + scrnDim.getWidth() / 80;
        int x4 = x3;
        int x5 = x2;
        int x6 = x1;
        int x7 = x0;
        int x8 = x0;

        int[] xPoints = {x0, x1, x2, x3, x4, x5, x6, x7, x8};
        return xPoints;

    }

    private int[] createOctogonYPoints(int outlineValue) {
        int y0 = (int) location.y + scrnDim.getWidth() / 80 - outlineValue;
        int y1 = (int) location.y - outlineValue;
        int y2 = y1;
        int y3 = y0;
        int y4 = y0 + scrnDim.getWidth() / 60 + outlineValue;
        int y5 = y4 + scrnDim.getWidth() / 80 + outlineValue;
        int y6 = y5;
        int y7 = y4;
        int y8 = y0;

        int[] yPoints = {y0, y1, y2, y3, y4, y5, y6, y7, y8};
        return yPoints;
    }

}
