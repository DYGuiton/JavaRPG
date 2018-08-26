package UI;

import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.io.Serializable;

/**
 * @author Yurichi
 */
public class ScreenDimensions implements Serializable{

    private int x, y, width, height;

    public ScreenDimensions() {
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        int taskBarHeight = scrnSize.height - winSize.height;
        x = 0;
        y = 0;
        width = tk.getScreenSize().width;
        height = tk.getScreenSize().height - taskBarHeight;
    }
    
    public int getX(){
        return x;
    }
    
    public int getY(){
        return y;
    }
    
    public int getWidth(){
        return width;
    }
    
    public int getHeight(){
        return height;
    }
    
    
}
