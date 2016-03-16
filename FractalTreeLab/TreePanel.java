//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 400;
    private final int PANEL_HEIGHT = 500;
    private final double EPSILON = 10E-4;
    private final double SQ = Math.sqrt(3.0) / 6;

    private final int XONE = 200, YONE = 500;
    private final int XTWO = 200, YTWO = 400;
    private final double INITLENGTH = 100;
    private final double INITANGLE = (Math.PI / 3);

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel ()
    {
        setBackground (Color.WHITE);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
//     public void drawFractal (double x1, double y1, double length, double angle, Graphics2D g2)
//     {
//         double deltaX, deltaY, x2, y2, angle2;
//         //make terminating condition branch length
//         if (length <= EPSILON)
//             return;
//         else
//         {
//             g2.drawLine(x1,y1,XTWO,YTWO);
//             deltaX = length * Math.sin(angle);
//             deltaY = length * Math.cos(angle);
//             //          drawFractal (x1, y1,,, page);
//             //          drawFractal (x2, y2,,, page);
//             //          drawFractal (x3, y3,,, page);
//             //          drawFractal (x4, y4,,, page);
//         }
//     }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics2D g2)
    {
        super.paintComponent (g2);

        g2.setColor (Color.BLACK);

        g2.drawLine (XONE, YONE, XTWO, YTWO);
    }
}
