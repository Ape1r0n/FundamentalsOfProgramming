package pgdp.penguinDate;

public class Penguin {
    private String name;
    private String parent;
    private int allowance;
    public Penguin(String name,int allowance) {
        this.name = name;
        this.allowance = allowance;
    }

    public Penguin(String name, String parent, int allowance) {
        this.name = name;
        this.parent = parent;
        this.allowance = allowance;
    }

    public String getName() {
        return name;
    }

    public String getParentName() {
        return parent;
    }

    public int getAllowance() {
        return allowance;
    }

    @Override
    public String toString() {
        return "Penguin{" +
                "name='" + name + '\'' +
                ", parent=" + parent +
                ", allowance=" + allowance +
                '}';
    }
}
