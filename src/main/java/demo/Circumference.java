package demo;

import java.lang.Math;

public class Circumference{

  public static double triangle(double a, double b, double c){
    if(a<0 || b<0 || c<0) return 0;
    return a+b+c;
  }

  public static double rectangle(double a, double b) {
    if(a<0 || b<0) return 0;
    return 2*a+2*b;
  }

  public static double square(double a){
    if(a<0) return 0;
    return a*4;
  }

  public static double circle(double r){
    if(r<0) return 0;
    return 2*r*Math.PI;
  }

}
