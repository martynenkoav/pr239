package com.problem;

import com.bot.Point;

/**
 * Created by Анастасия on 22.01.2017.
 */
public class Triangle {
    double a;
    double b;
    double c;
    @Override
    public String toString() {
        return "Triangle{"+ a+","+b+","+c+"}";
    }

    public Triangle(Point a, Point b, Point c){
        this.a=Math.round(a.getLength(b));
        this.b=Math.round(b.getLength(c));
        this.c=Math.round(c.getLength(a));
    }
    public boolean isEquilateral(){
        return this.a==this.b&&this.a==this.c;
        }
    }

