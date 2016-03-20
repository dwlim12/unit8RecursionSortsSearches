//********************************************************************
//  KochPanel.java       Author: Lewis/Loftus/Cocking
//
//  Represents a drawing surface on which to paint a Koch Snowflake.
//********************************************************************

import java.awt.*;
import javax.swing.JPanel;
import java.awt.geom.Point2D;
import java.awt.geom.Line2D;

public class TreePanel extends JPanel
{
    private final int PANEL_WIDTH = 450;
    private final int PANEL_HEIGHT = 500;
    private final double EPSILON = 10E-4;
    private final double SQ = Math.sqrt(3.0) / 6;

    private final int XONE = 200, YONE = 500;
    private final int XTWO = 200, YTWO = 400;
    private final double INITLENGTH = 100;
    private final double INITANGLE = 50;

    //-----------------------------------------------------------------
    //  Sets the initial fractal order to the value specified.
    //-----------------------------------------------------------------
    public TreePanel ()
    {
        setBackground (Color.BLACK);
        setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
    }

    //-----------------------------------------------------------------
    //  Draws the fractal recursively. Base case is an order of 1 for
    //  which a simple straight line is drawn. Otherwise three
    //  intermediate points are computed, and each line segment is
    //  drawn as a fractal.
    //-----------------------------------------------------------------
    public void drawFractal(int x1, int y1, double length, double angle, Graphics2D g2)
    {
        double angleL, angleR, newLength;
        int xL, yL, xR, yR;
        //make terminating condition branch length
        if (length <= 1)
            return;
        else
        {
            angleL = angle + INITANGLE;
            angleR = angle - INITANGLE - 50;
            newLength = length * (2.0/3.0);
            xL = (int)(length*Math.sin(angleL) + x1);
            yL = (int)(y1 - length*Math.cos(angleL));
            xR = (int)(length*Math.sin(angleR) + x1);
            yR = (int)(y1 - length*Math.cos(angleR));
            g2.setColor(Color.RED);
            g2.drawLine(x1,y1,xL,yL);
            g2.setColor(Color.BLUE);
            g2.drawLine(x1,y1,xR,yR);
            
            drawFractal(xL,yL,newLength,angleL,g2);
            drawFractal(xR,yR,newLength,angleR,g2);
        }
    }

    //-----------------------------------------------------------------
    //  Performs the initial calls to the drawFractal method.
    //-----------------------------------------------------------------
    public void paintComponent (Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent (g2);
        g2.setColor(Color.MAGENTA);
        g2.drawLine(XONE,YONE,XTWO,YTWO);
        drawFractal(XTWO,YTWO,INITLENGTH,0,g2);
    }
}
