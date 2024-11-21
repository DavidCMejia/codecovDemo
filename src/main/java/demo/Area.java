package demo;

import java.lang.Math;

public class Area{

    public static double triangle(double b, double h){
      if(b<0 || h<0) return 0;
      return (b*h)/2;
    }

    public static double rectangle(double b, double h) {
      if(b<0 || h<0) return 0;
      return b*h;
    }

    public static double square(double s){
      if(s<0) return 0;
      return rectangle(s,s);
    }

    public static double circle(double r) {
      if(r<0) return 0;
      return Math.PI*Math.pow(r,2);
    }

}
