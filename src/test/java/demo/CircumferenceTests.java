package demo;

import java.lang.Math;
import org.junit.Assert;
import org.junit.Test;


public class CircumferenceTests {
    private Circumference c = new Circumference();
    // Triangle
    @Test
    public void checkTriangleValidInput(){
        double a = 10;
        double b = 10;
        double z = 10;
        double actual = c.triangle(a,b,z);
        double expected = 30;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkTriangleAreaInvalidAInput(){
        double a = -10;
        double b = 10;
        double z = 10;
        double actual = c.triangle(a,b,z);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkTriangleAreaInvalidBInput(){
        double a = 10;
        double b = -10;
        double z = 10;
        double actual = c.triangle(a,b,z);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkTriangleAreaInvalidCInput(){
        double a = 10;
        double b = 10;
        double z = -10;
        double actual = c.triangle(a,b,z);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    // Rectangle
    @Test
    public void checkRectangleValidInput(){
        double a = 10;
        double b = 20;
        double actual = c.rectangle(a,b);
        double expected = 60;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkRectangleAreaInvalidAInput(){
        double a = -10;
        double b = 20;
        double actual = c.rectangle(a,b);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkRectangleAreaInvalidBInput(){
        double a = 10;
        double b = -20;
        double actual = c.rectangle(a,b);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    // Square
    @Test
    public void checkSquareAreaValidInput(){
        double s = 10;
        double actual = c.square(s);
        double expected = 40;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkSquareAreaInvalidSideInput(){
        double s = -10;
        double actual = c.square(s);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    // Circle
    @Test
    public void checkCircleAreaValidInput(){
        double radius = 10;
        double expected = Math.PI * 2 * radius;
        double actual = c.circle(radius);
        Assert.assertEquals(0, Double.compare(expected, actual));
    }
    @Test
    public void checkCircleAreaInvalidInput(){
        double radius = -10;
        double actual = c.circle(radius);
        double expected = 0;
        Assert.assertEquals(0, Double.compare(expected, actual));
    }

}
