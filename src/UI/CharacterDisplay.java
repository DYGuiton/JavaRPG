package UI;

import CharacterComponents.RPGCharacter;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * @author Yurichi
 */
class CharacterDisplay {

    RPGCharacter theCharacter;
    Rectangle2D.Double shape;
    String name;

    boolean mouseOver = false;

    int truX, truY;
    int x, y, width, height;

    public CharacterDisplay() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
        //refreshDisplay();
    }

    public void setBounds(int truX, int truY, int x, int y, int width, int height) {
        this.truX = truX;
        this.truY = truY;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        shape = new Rectangle2D.Double();
        shape.setRect(truX, truY+y, width, height);
    }

    public void setCharacter(RPGCharacter nuCharacter) {
        theCharacter = nuCharacter;
    }

    private void refreshDisplay() {

    }

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        if (mouseOver) {
            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, height);

            g2.setStroke(new BasicStroke(3));
            g2.setFont(new Font("Impact", Font.BOLD, 20));
            g2.setColor(Color.ORANGE);
            g2.drawString(theCharacter.getName(), x + width / 3, y + height / 3);

            g2.fillRect(x + width / 3, (int) (y + height / 2.90), width / 2, height / 30);

            g2.drawRect(x, y, width, height);
        } else {
            g2.setColor(Color.WHITE);
            g2.fillRect(x, y, width, height);

            g2.setStroke(new BasicStroke(3));
            g2.setFont(new Font("Impact", Font.BOLD, 20));
            g2.setColor(Color.BLACK);
            g2.drawString(theCharacter.getName(), x + width / 3, y + height / 3);

            g2.fillRect(x + width / 3, (int) (y + height / 2.90), width / 2, height / 30);

            g2.drawRect(x, y, width, height);
        }
    }

    public boolean contains(Point2D.Double point) {
        return shape.contains(point);
    }

    public void setMouseOver(boolean nuMouseOver) {
        mouseOver = nuMouseOver;
    }
}
