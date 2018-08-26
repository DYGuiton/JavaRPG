/*
 * @(#)SimpleDemo.java   6/13/11
 * 
 * Copyright (c) 2011. JShapes.com. All rights reserved.
 * http://www.jshapes.com
 */

import com.jshapes.g2d.shapes.stars.Star;

import javax.swing.*;
import java.awt.*;

/**
 * The <code>SimpleDemo</code> class description.
 *
 * @author Kumaravel Somasundaram
 * @version 1.0 6/13/11
 */
public class SimpleDemo extends JPanel {


    /**
     * Constructs <code>SimpleDemo</code>
     */
    public SimpleDemo() {
        setBackground( Color.white );
    }

    /**
     * Draws Star shape
     * @param g2
     */
    private void drawShape(Graphics2D g2) {
        // Set parameters 
        Rectangle bounds = new Rectangle( 10, 10, 100, 100 );
        double tipSize = 40 ;
        String style = Star.STAR_16_POINTS;

        // 1. Create Shape
        Star star = new Star( bounds,  tipSize, style );

        // 2. Fill Shape
        g2.setPaint( Color.yellow );
        g2.fill( star );

        // 3. Draw Shape
        g2.setPaint( Color.blue );
        g2.draw(star);

    }

    /**
     * Paints this component
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Rectangle bounds = this.getBounds();
        Shape oldClip = g2.getClip();
        g2.setClip( 0, 0, bounds.width, bounds.height );

        drawShape(g2);

        g2.setClip( oldClip );

    }

    /**
     * Main method to run this program
     * @param args
     */
    public static void main(String[] args) {

        JFrame frame = new JFrame( "JShapes Demo");
        frame.setSize( new Dimension( 1000, 800 ));
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.getContentPane().add( new SimpleDemo() );
        frame.setVisible( true );

    }

}
/*
 * @(#)SimpleDemo.java   6/13/11
 * 
 * Copyright (c) 2011. JShapes.com. All rights reserved.
 * http://www.jshapes.com
 */

