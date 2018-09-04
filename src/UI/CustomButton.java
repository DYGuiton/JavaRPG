package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public abstract class CustomButton extends CustomIcon {
    
    Color outlineColor;
    

    public CustomButton(Point2D.Double nuLocation, Color nuColor, int nuSize, ScreenDimensions nuScrnDim) {
        super(nuLocation, nuColor, nuSize, nuScrnDim);
    }

    @Override
    public abstract void paint(Graphics g);
    
    
    public abstract boolean mousePressed();
    
    public abstract void drawOutline(Graphics2D g2, int size);

}
