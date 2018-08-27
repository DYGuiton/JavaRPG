package UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

/**
 * @author Yurichi
 */
public abstract class CustomButton extends CustomIcon {
    

    public CustomButton(Point2D.Double nuLocation, Color nuColor, int nuSize, ScreenDimensions nuScrnDim) {
        super(nuLocation, nuColor, nuSize, nuScrnDim);
    }

    @Override
    public abstract void paint(Graphics g);
    
    
    public abstract void mousePressed();

}
