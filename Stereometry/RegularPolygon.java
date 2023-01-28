package Stereometry;

public class RegularPolygon extends BaseArea{
    private int n;
    private double length;

    @Override
    public double circumference() {
        return n * length;
    }

    public RegularPolygon(int n, double length) {
        this.n = n;
        this.length = length;
    }

    @Override
    public double area() {
        return (n * length * length)/(4 * Math.tan(Math.PI/n));
    }

    public int getN() {
        return n;
    }

    public double getLength() {
        return length;
    }

    public boolean isSquare(){
        return n == 4;
    }

    public Square toSquare(){
        Square result = null;
        if(this.isSquare()) result = new Square(this.length);
        return result;
    }

    public String toString(){
        return "Rac minda";
    }
}