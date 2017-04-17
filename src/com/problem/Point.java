

/**
 * Created by Анастасия on 08.03.2017.
 */
public class Point {
    double x;
    double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public double getLength(Point a2){
        return Math.sqrt((this.x-a2.x)*(this.x-a2.x)+(this.y-a2.y)*(this.y-a2.y));
}
}
