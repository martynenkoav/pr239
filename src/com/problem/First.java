import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;


/**
 * Created by Анастасия on 22.01.2017.
 */
public class First {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int cnt=0;
        Point [] arr=new Point[n];
        for(int i=0;i<n;i++){
            arr[i]=new Point(sc.nextDouble(),sc.nextDouble());
        }
        for(int i=0;i<n;i++){
            for (int j=i+1;j<n;j++){
                for (int k=j+1;k<n;k++){
                    Point a=arr[i];
                    Point b=arr[j];
                    Point c=arr[k];
                    Triangle tr=new Triangle(a,b,c);
                    if (tr.isEquilateral()==false){
                        cnt+=1;
                    }
                }
            }
        }
        System.out.println(cnt==0?true:false);
    }
    }
