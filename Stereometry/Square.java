package Stereometry;

public class Square extends BaseArea{
    private double length;

    public double getLength() {
        return length;
    }

    public Square(double length) {
        this.length = length;
    }

    public double area(){
        return length * length;
    }

    public double circumference(){
        return  4 * length;
    }

    public boolean isSquare(){
        return true;
    }

    public Square toSquare(){
        return new Square(length);
    }

    public String toString(){
        return "Rac minda";
    }
}
