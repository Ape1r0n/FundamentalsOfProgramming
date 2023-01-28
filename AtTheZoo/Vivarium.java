package AtTheZoo;

public class Vivarium{
    private int area, constructionYear;
    private Animal[] inhabitants;

    public Vivarium(Animal[] inhabitants, int area, int constructionYear){
        this.inhabitants = inhabitants;
        this.area = area;
        this.constructionYear = constructionYear;
    }

    public Animal[] getInhabitants(){
        return this.inhabitants;
    }

    public int getArea(){
        return this.area;
    }

    public int getConstructionYear(){
        return this.constructionYear;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setInhabitants(Animal[] inhabitants) {
        this.inhabitants = inhabitants;
    }

    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("area: " + this.area + ", constructionYear: " + this.constructionYear + ", animals:");
        for(int i=0; i < this.inhabitants.length; i++){
            if(i == 0) builder.append(" (name: " + inhabitants[i].getName() + ", foodCosts: " + inhabitants[i].getFoodCosts() + ")");
            else builder.append(", (name: " + inhabitants[i].getName() + ", foodCosts: " + inhabitants[i].getFoodCosts() + ")");
        }
        return builder.toString();
    }

    public int getCosts(){
        int f_Costs = 0;
        for(Animal animal : inhabitants){
            f_Costs += animal.getFoodCosts();
        }
        return f_Costs + 900 + area*area*100 + area*area*(2021-constructionYear)*5;
    }
}