package com.bot;

import com.bot.Point;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

/**
 * Created by Анастасия on 22.01.2017.
 */
public class Triangle extends JPanel {
    double aLength;
    double bLength;
    double cLength;

    Point a, b, c;


    public static int max3(int a, int b, int c){
        return Math.max(Math.max(a,b),c);
    }


    public int[] getTrBounds(){
        int arr [] = {
                0,
                0,
                max3(a.x,b.x,c.x)+3,
                max3(a.y,b.y,c.y)+3,

        };
        return arr;
    }
    public Triangle(Point a, Point b, Point c) {
        this.aLength = Math.round(a.getLength(b));
        this.bLength = Math.round(b.getLength(c));
        this.cLength = Math.round(c.getLength(a));

        this.a = a;
        this.b = b;
        this.c = c;

    }

    public boolean isEquilateral() {
        return this.aLength == this.bLength && this.aLength == this.cLength;
    }

    public boolean isSame() {return this.a == this.b || this.c==this.a || this.b==this.c;}

    public void paint(Graphics g) {
        g.setColor(Color.BLUE);
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(a.x, a.y, c.x, c.y);
        g.drawLine(b.x, b.y, c.x, c.y);

    }
}



