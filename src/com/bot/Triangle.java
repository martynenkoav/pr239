package com.bot;

import com.bot.Point;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Анастасия on 22.01.2017.
 */
public class Triangle extends JPanel {
    double aLength;
    double bLength;
    double cLength;

    Point a, b, c;

    @Override
    public String toString() {
        return "Triangle{" + aLength + "," + bLength + "," + cLength + "}";
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


    public void paint(Graphics g) {
        g.setColor(Color.RED);
        g.drawLine(a.x, a.y, b.x, b.y);
        g.drawLine(a.x, a.y, c.x, c.y);
        g.drawLine(b.x, b.y, c.x, c.y);

    }
}

