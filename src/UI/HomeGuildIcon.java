package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Yurichi
 */
public class HomeGuildIcon extends CustomIcon {

    Polygon baseShape, outline;
    Rectangle2D.Double barShape;
    String guildName;

    public HomeGuildIcon(Point2D.Double nuLocation, Color nuColor, int nuSize, ScreenDimensions nuScrnDim) {
        super(nuLocation, nuColor, nuSize, nuScrnDim);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        drawShape(g2, 1);
    }

    @Override
    public void setShape() {
        int[] xPoints = createXPoints(0);
        int[] yPoints = createYPoints(0);
        baseShape = new Polygon(xPoints, yPoints, 5);

        barShape = new Rectangle2D.Double(xPoints[1], scrnDim.getHeight() / 30, scrnDim.getWidth() / 4, scrnDim.getHeight() / 20);

        xPoints = createXPoints(2);
        yPoints = createYPoints(2);
        outline = new Polygon(xPoints, yPoints, 5);

    }

    @Override
    public void drawShape(Graphics2D g2, int size) {
        g2.setColor(Color.BLACK);
        g2.fill(barShape);
        g2.setColor(color);
        g2.fill(baseShape);
        g2.setStroke(new BasicStroke(4));
        g2.setColor(Color.black);
        g2.draw(outline);

        g2.setFont(new Font("Palatino Linotype", Font.ITALIC, 24));
        g2.setColor(Color.LIGHT_GRAY);
        g2.drawString(guildName, baseShape.xpoints[2], scrnDim.getHeight() / 15);
    }

    @Override
    public void fillShape(Graphics2D g2) {
        g2.fill(baseShape);
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return baseShape.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
    }

    private int[] createXPoints(int offset) {
        int x0 = (int) location.x;
        int x1 = (int) location.x + scrnDim.getWidth() / 25;
        int x2 = (int) x1 + scrnDim.getWidth() / 25;
        int x3 = x1;
        int x4 = x0;

        int[] xPoints = {x0, x1, x2, x3, x4};
        return xPoints;
    }

    private int[] createYPoints(int offset) {
        int y0 = (int) location.y + scrnDim.getWidth() / 20;
        int y1 = (int) location.y;
        int y2 = (int) y0;
        int y3 = (int) y0 + scrnDim.getWidth() / 20;
        int y4 = (int) y0;

        int[] yPoints = {y0, y1, y2, y3, y4};
        return yPoints;
    }

    public void setGuildName(String name) {
        guildName = name;
    }

}
