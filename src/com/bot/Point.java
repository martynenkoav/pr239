package com.bot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by nurgalievtr.18 on 10.04.2017.
 */
public class Point extends JPanel {
    public int x;
    public int y;
    public boolean rmt;

    public Point(int x, int y){
        this.x=x;
        this.y=y;
        this.rmt=false;
    }

    public boolean isRmt() {
        return rmt;
    }

    public void setRmt(boolean rmt) {
        this.rmt = rmt;
    }

    public void paint(Graphics g){
        g.fillRect(0,0,3,3);
        g.setColor(Color.BLACK);
    }
    public double getLength(Point a2){
        return Math.sqrt((this.x-a2.x)*(this.x-a2.x)+(this.y-a2.y)*(this.y-a2.y));
    }
}
