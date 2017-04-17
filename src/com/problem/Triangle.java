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

    Triangle(Point a,Point b, Point c){
        this.a=Math.round(a.getLength(b)*1000)/1000;
        this.b=Math.round(b.getLength(c)*1000)/1000;
        this.c=Math.round(c.getLength(a)*1000)/1000;
    }
    boolean isEquilateral(){
        return this.a==this.b&&this.a==this.c;
        }
    }

