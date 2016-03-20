//********************************************************************
//  KochSnowflakeViewer.java       Author: Lewis/Loftus/Cocking
//
//  Demonstrates the use of recursion.
//  @gcschmit (19 July 2014): converted from an applet to an application
//********************************************************************

import java.awt.*;
import javax.swing.*;

public class TreeViewer extends JFrame
{
    private final int WIDTH = 500;
    private final int HEIGHT = 550;

    private JLabel titleLabel;
    private TreePanel drawing;
    private JPanel panel;
    private JFrame frame;

    //-----------------------------------------------------------------
    //  Sets up the components for the applet.
    //-----------------------------------------------------------------
    public static void main(String[] args)
    {
        TreeViewer viewer = new TreeViewer();
    }

    public TreeViewer()
    {
        drawing = new TreePanel();
        
        panel = new JPanel();
        panel.add (drawing);

        this.setTitle("Fractal Tree");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.add(panel);
        this.setVisible(true);
    }
}
