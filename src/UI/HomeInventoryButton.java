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
public class HomeInventoryButton extends CustomButton {

    Ellipse2D.Double shape, outline;

    public HomeInventoryButton(Point2D.Double location, Color color, Color nuOutlineColor, int size, ScreenDimensions scrnDim) {

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
            g2.drawString("Inventory", (int) (location.x + scrnDim.getWidth() / 400), (int) (location.y + scrnDim.getHeight() / 10));
        } else {
            g2.setColor(Color.BLACK);
            g2.drawString("Inventory", (int) (location.x + scrnDim.getWidth() / 400), (int) (location.y + scrnDim.getHeight() / 10));

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

}
