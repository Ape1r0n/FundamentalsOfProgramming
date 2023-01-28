package AtTheZoo;

public class Zoo{
    private Vivarium[] vivaria;

    public Zoo(Vivarium[] vivaria) {
        this.vivaria = vivaria;
    }

    public Vivarium[] getVivaria() {
        return vivaria;
    }

    public void setVivaria(Vivarium[] vivaria) {
        this.vivaria = vivaria;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(int i=0; i < vivaria.length; i++){
            if(i == vivaria.length - 1) builder.append("[" + vivaria[i].toString() + "]");
            else builder.append("[" + vivaria[i].toString() + "], ");
        }
        builder.append("}");
        return builder.toString();
    }

    public int getCosts(){
        int res = 0;
        for(Vivarium element : vivaria)
            res += element.getCosts();
        return res;
    }
}
