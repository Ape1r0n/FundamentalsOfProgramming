package Stereometry;

public class Rectangle extends BaseArea{
    private double width;
    private double height;

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double circumference() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public boolean isSquare(){
        return height == width;
    }

    public Square toSquare(){
        Square result = null;
        if(this.isSquare()) result = new Square(width);
        return result;
    }

    public String toString(){
        return "Rac minda";
    }
}