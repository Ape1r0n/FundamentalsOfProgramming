package Stereometry;

import java.lang.Math;

public class Circle extends BaseArea{
    private double radius;

    public double getRadius() {
        return radius;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double circumference() {
        return Math.PI * 2 * radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }

    public String toString(){
        return "Rac minda";
    }

}
