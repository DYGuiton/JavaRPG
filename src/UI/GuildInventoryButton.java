package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public class GuildInventoryButton extends CustomButton {

    Ellipse2D.Double shape, outline;
    Color outlineColor;

    public GuildInventoryButton(Point2D.Double location, Color color, Color nuOutlineColor, int size, ScreenDimensions scrnDim) {

        super(location, color, size, scrnDim);
        outlineColor = nuOutlineColor;

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(2));
        drawShape(g2);
        if (mouseOver) {
            g.setColor(color);
            fillShape(g2);
            g.setColor(outlineColor);
            drawOutline(g2);
        }
    }

    @Override
    public void setShape() {
        shape = new Ellipse2D.Double(location.getX(), location.getY(), width, height);
        outline = new Ellipse2D.Double(location.getX() - 2, location.getY() - 2, width + 4, height + 4);
    }

    @Override
    public boolean contains(Point2D.Double mousePosition) {
        return shape.contains(mousePosition);
    }

    @Override
    public void mouseOverAction() {
        mouseOver = true;
    }

    @Override
    public void mousePressed() {
        System.out.println("Button Pressed");
        //further implementation later
    }

    @Override
    public void drawShape(Graphics2D g2) {
        g2.setColor(color);
        g2.draw(shape);
    }

    @Override
    public void fillShape(Graphics2D g2) {
        g2.setColor(color);
        g2.fill(shape);
    }

    public void drawOutline(Graphics2D g2) {
        g2.setStroke(new BasicStroke(3));
        g2.setColor(outlineColor);
        g2.draw(outline);
        g2.setStroke(new BasicStroke(2));
    }

}
