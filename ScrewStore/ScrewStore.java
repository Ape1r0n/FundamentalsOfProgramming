package ScrewStore;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ScrewStore{
    private Map<Screw, Integer> stock;
    private LinkedList<Order> orders;

    public Map<Screw, Integer> getStock() {
        return stock;
    }

    public ScrewStore(){
        stock = new HashMap<>();
        orders = new LinkedList<>();
    }

    public void addItem(Screw type, int amount){
        Integer value = stock.get(type);
        if(value != null) stock.put(type,value+amount);
        else stock.put(type,amount);
    }

    public void takeOrder(Screw type, int amount){
        orders.add(new Order(type,amount));
    }

    public boolean executeOrder() {
        if (orders.isEmpty()) return false;
        if (orders.getFirst().getAmount() != 0){
            if (orders.getFirst().getAmount() > stock.get(orders.getFirst().getScrew())) return false;
            else if (orders.getFirst().getAmount() == stock.get(orders.getFirst().getScrew())) {
                stock.remove(orders.getFirst().getScrew());
                return true;
            }else {
                stock.replace(orders.getFirst().getScrew(), stock.get(orders.getFirst().getScrew()) - orders.getFirst().getAmount());
                return true;
            }
        }
        return false;
    }

    public void inflation(double percent){
        for(Screw key : stock.keySet()){
            key.setPrice(key.getPrice()*(1+percent));
        }
    }

    public int count(){
        int total = 0;
        for(Screw key : stock.keySet()){
            total += key.getPrice();
        }
        return total;
    }

    public double value(){
        int total = 0;
        for(Map.Entry<Screw, Integer> k : stock.entrySet()){
            total += k.getKey().getPrice() * k.getValue();
        }
        return total;
    }

    public String stockToString(){
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Screw, Integer> k : stock.entrySet()){
            sb.append(k.getValue());
            sb.append("x ");
            sb.append(k.getKey());
            sb.append("\n");
        }
        return sb.toString();
    }
}