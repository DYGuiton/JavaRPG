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
public class HomeRecordsButton extends CustomButton {

    Polygon shape, outline;

    public HomeRecordsButton(Point2D.Double location, Color color, Color nuOutlineColor, int size,
            ScreenDimensions scrnDim) {
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
            g2.drawString("Records", (int) (location.x + scrnDim.getWidth() / 125), (int) (location.y + scrnDim.getHeight() / 10));

        } else {
            g2.setColor(Color.BLACK);
            g2.drawString("Records", (int) (location.x + scrnDim.getWidth() / 125), (int) (location.y + scrnDim.getHeight() / 10));

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
        int[] xPoints = createScrollXPoints(0);
        int[] yPoints = createScrollYPoints(0);
        shape = new Polygon(xPoints, yPoints, 13);

        xPoints = createScrollXPoints(2);
        yPoints = createScrollYPoints(2);
        outline = new Polygon(xPoints, yPoints, 13);
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
    public boolean contains(Point2D.Double mousePosition) {
        return shape.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
        mouseOver = true;
    }

    private int[] createScrollXPoints(int outlineVal) {
        int x0 = (int) location.x - outlineVal;
        int x1 = (int) location.x + scrnDim.getWidth() / 22 + outlineVal;
        int x2 = (int) x1;
        int x3 = (int) x1 - scrnDim.getWidth() / 150;
        int x4 = (int) x3;
        int x5 = (int) x1;
        int x6 = (int) x1;
        int x7 = (int) x0;
        int x8 = (int) x0;
        int x9 = (int) x0 + scrnDim.getWidth() / 150;
        int x10 = (int) x9;
        int x11 = x0;
        int x12 = x0;
        int[] xPoints = {x0, x1, x2, x3, x4, x5, x6, x7, x8, x9, x10, x11, x12};

        return xPoints;
    }

    private int[] createScrollYPoints(int i) {
        int y0 = (int) location.y;
        int y1 = y0;
        int y2 = (int) y0 + scrnDim.getWidth() / 60;
        int y3 = y2;
        int y4 = y0 + scrnDim.getWidth() / 40;
        int y5 = y4;
        int y6 = y4 + scrnDim.getWidth() / 60;
        int y7 = y6;
        int y8 = y4;
        int y9 = y4;
        int y10 = y2;
        int y11 = y2;
        int y12 = y0;
        int[] yPoints = {y0, y1, y2, y3, y4, y5, y6, y7, y8, y9, y10, y11, y12};

        return yPoints;
    }

}
