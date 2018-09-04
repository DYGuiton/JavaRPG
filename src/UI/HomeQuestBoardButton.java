package UI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Yurichi
 */
public class HomeQuestBoardButton extends CustomButton {

    Rectangle2D.Double shape, outline;

    public HomeQuestBoardButton(Point2D.Double location, Color color, Color nuOutlineColor, int size, ScreenDimensions scrnDim) {
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
            Font oldFont = g2.getFont();
            g2.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
            g2.drawString("Quest Board", (int) (location.x - shape.width / 2.75), (int) (location.y + height / 1.5));
            g2.setFont(oldFont);
        } else {
            Font oldFont = g2.getFont();
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Palatino Linotype", Font.BOLD, 30));
            g2.drawString("Quest Board", (int) (location.x - shape.width / 2.75), (int) (location.y + height / 1.5));
        }
    }

    @Override
    public boolean mousePressed() {
        System.out.println("Button Pressed");
        //further implementation later
    }

    @Override
    public void drawOutline(Graphics2D g2, int size) {
        g2.setStroke(new BasicStroke(3));
        g2.setColor(outlineColor);
        g2.draw(outline);
        g2.setStroke(new BasicStroke(2));
    }

    @Override
    public void setShape() {
        shape = new Rectangle2D.Double(location.getX() - (width * 4) / 2, location.getY(), width * 4, height);
        outline = new Rectangle2D.Double(location.getX() - (width * 4) / 2 - 2, location.getY() - 2, width * 4 + 4, height + 4);
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

}
