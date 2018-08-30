package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public class HomeGuildButton extends CustomButton {

    Polygon shape0, outline0;
    Ellipse2D.Double shape1, outline1;
    Color circleColor;

    public HomeGuildButton(Point2D.Double location, Color starColor, Color nuCircleColor, Color nuOutlineColor,
            int size, ScreenDimensions scrnDim) {
        super(location, starColor, size, scrnDim);
        outlineColor = nuOutlineColor;
        circleColor = nuCircleColor;

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(3));
        drawShape(g2, 2);
        if (mouseOver) {
            g.setColor(color);
            fillShape(g2);
            g.setColor(outlineColor);
            drawOutline(g2, 3);
            g2.setColor(Color.ORANGE);
            g2.drawString("Guild", (int) (location.x + scrnDim.getWidth() / 80), (int) (location.y + scrnDim.getHeight() / 10));

        } else {
            g2.setColor(Color.BLACK);
            g2.drawString("Guild", (int) (location.x + scrnDim.getWidth() / 80), (int) (location.y + scrnDim.getHeight() / 10));
        }
    }

    @Override
    public void mousePressed() {
        System.out.println("Button Pressed");
        //further implementation later        
    }

    @Override
    public void setShape() {
        int[] xPoints = createStarXPoints(0);
        int[] yPoints = createStarYPoints(0);
        shape0 = new Polygon(xPoints, yPoints, 5);

        shape1 = new Ellipse2D.Double(location.getX() + width / 5, location.getY() + height / 5,
                (int) width / 1.5, (int) height / 1.5);
        outline1 = new Ellipse2D.Double((location.getX() + width / 5) - 2, (location.getY() + height / 5) - 2,
                ((int) width / 1.5) + 4, ((int) height / 1.5) + 4);

        xPoints = createStarXPoints(2);
        yPoints = createStarYPoints(2);
        outline0 = new Polygon(xPoints, yPoints, 6);

    }

    @Override
    public void drawShape(Graphics2D g2, int size) {
        g2.setColor(circleColor);
        g2.fill(shape1);
        g2.setColor(color);
        g2.draw(shape0);
    }

    @Override
    public void fillShape(Graphics2D g2) {
        g2.setColor(circleColor);
        g2.fill(shape1);
        g2.setColor(color);
        g2.fill(shape0);
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return shape0.contains(mousePosition) || shape1.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
        mouseOver = true;
    }

    @Override
    public void drawOutline(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(size));
        g2.setColor(outlineColor);
        g2.draw(outline0);
        g2.draw(outline1);
        g2.setStroke(new BasicStroke(2));
    }

    private int[] createStarXPoints(int outlineVal) {

        int x0 = (int) location.x - outlineVal;
        int x1 = (int) location.x + scrnDim.getWidth() / 45;
        int x2 = (int) x1 + scrnDim.getWidth() / 45 + outlineVal;
        int x3 = (int) x1 + scrnDim.getWidth() / 55 + outlineVal;
        int x4 = (int) x1 - scrnDim.getWidth() / 55 - outlineVal;

        int[] xPoints = {x0, x2, x4, x1, x3, x0};

        return xPoints;
    }

    private int[] createStarYPoints(int outlineVal) {
        int y0 = (int) (location.y + scrnDim.getWidth() / 65);
        int y1 = (int) location.y - outlineVal;
        int y2 = y0;
        int y3 = y0 + scrnDim.getWidth() / 40 + outlineVal;
        int y4 = y3;
        int y5 = y0;

        int[] yPoints = {y0, y2, y4, y1, y3, y5};
        return yPoints;
    }

}
