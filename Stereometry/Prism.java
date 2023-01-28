package Stereometry;

public class Prism{
    private double height;
    private BaseArea base;

    public double getHeight() {
        return height;
    }

    public BaseArea getBase(){
        return base;
    }

    public Prism(double height, BaseArea base) {
        this.height = height;
        this.base = base;
    }

    public double surface(){
        return height * base.circumference() + 2 * base.area();
    }

    public double volume(){
        return base.area() * height;
    }

    public boolean isCube(){
        return base.isSquare() && base.toSquare().getLength() == height;
    }

    public String toString(){
        return "Rac minda";
    }
}