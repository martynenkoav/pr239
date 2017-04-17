/**
 * Created by Анастасия on 05.02.2017.
 */
public class Frac {
    int numerator;
    int denominator;
    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }
    Frac sum(Frac a){
        Frac f = new Frac();
        f.numerator = this.numerator*a.denominator+this.denominator*a.numerator;
        f.denominator=this.denominator*a.denominator;
        return f;
    }
    Frac sum(int a){
        Frac fr= new Frac();
        fr.numerator = this.numerator+denominator*a;
        fr.denominator=this.denominator;
        return fr;
    }
    Frac mult(int a){
        Frac fra = new Frac();
        fra.numerator = this.numerator*a;
        fra.denominator=this.denominator;
        return fra;
    }
    Frac mult(Frac a){
        Frac frac = new Frac();
        frac.numerator = this.numerator*a.numerator;
        frac.denominator=this.denominator*a.denominator;
        return frac;
    }
    Frac div(int a){
        Frac fram = new Frac();
        fram.numerator = this.numerator;
        fram.denominator=this.denominator*a;
        return fram;
    }
    Frac inv(){
        Frac fre = new Frac();
        fre.numerator = this.denominator;
        fre.denominator=this.numerator;
        return fre;
    }
    boolean isDenumeratorZero(){
        return this.denominator==0;
    }
    boolean isShorten(){
        int b = this.denominator;
        int a = this.numerator;
        while (b !=0) {
            int tmp = a%b;
            a = b;
            b = tmp;
        }
        if (a != 1)
            return true;
        else
            return false;

    }

    Frac doShort(){
        Frac framt = new Frac();
        framt.numerator = this.numerator;
        framt.denominator=this.denominator;
        for ( int i=framt.numerator;i>=2; i-- ){
            if (framt.numerator%i==0&&framt.denominator%i==0){
                framt.numerator=framt.numerator/i;
                framt.denominator=framt.denominator/i;
            }
        }
        return framt;
    }
    boolean isEqual(Frac a) {
        Frac f1 = a.doShort();
        Frac f2 = this.doShort();
        return f1.numerator == f2.numerator && f1.denominator == f2.denominator;

    }
    int compareTo(Frac a){
        int m=this.numerator*a.denominator;
        int ma=a.numerator*this.denominator;
        if (m<ma)
            return -1;
        else
        if (m==ma)
            return 0;
        else
            return 1;


    }
}
