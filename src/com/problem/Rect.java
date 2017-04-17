/**
 * Created by Анастасия on 22.01.2017.
 */
public class Rect {
    double width;
    double height;

    @Override
    public String toString() {
        return "Rect{" +
                "width=" + width +
                ",height=" + height +
                '}';
    };
    Rect(){
        width=1;
        height=1;
    }
    Rect(double a){
        width=a;
        height=a;
    }
    Rect(double w, double h){
        width=w;
        height=h;
    }


    boolean isSquare() {
        if (this.width == this.height)
            return true;
        else
            return false;
    }
    double getArea() {
        return width * height;
    };
    double getPerimeter() {
        return 2 * (width + height);
    };

    Rect scale(double d){
        Rect rect3=new Rect();
        rect3.width = this.width*d;
        rect3.height = this.height*d;
        return rect3;
    };


    Rect scale(double w,double h){
        Rect rect3 = new Rect();
        rect3.width = this.width*w;
        rect3.height = this.height*h;
        return rect3;
    }
}
