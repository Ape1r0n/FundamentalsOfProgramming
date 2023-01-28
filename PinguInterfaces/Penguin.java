package PinguInterfaces;

public class Penguin extends Animal implements Comparable, Copyable{
    private String name;
    private double height;

    public Penguin(int age, String name, double height){
        this.age = age;
        this.name = name;
        this.height = height;
    }

    public void birthday(){
        this.age++;
        System.out.println("\uD83C\uDF82 <- \uD83D\uDC27");
    }

    public Penguin copy(){
        return new Penguin(this.age,this.name,this.height);
    }

    public int compareTo(Penguin other){
        if(this.age != other.age) return this.age - other.age;
        else if(this.height != other.height) return (int) Math.signum(this.height - other.height);
        else return this.name.compareTo(other.name);
    }

}