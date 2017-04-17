package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nurgalievtr.18 on 10.04.2017.
 */
public class Point extends JPanel {
    public int x;
    public int y;
    public Point(int x, int y){
        this.x=x;
        this.y=y;
    }
    public void paint(Graphics g){
        g.setColor(Color.GREEN);
        g.fillRect(0,0,3,3);
        g.setColor(Color.red);
    }
    public double getLength(Point a2){
        return Math.sqrt((this.x-a2.x)*(this.x-a2.x)+(this.y-a2.y)*(this.y-a2.y));
    }
}
