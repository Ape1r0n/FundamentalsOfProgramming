package pgdp.company;
import pgdp.tree.Node;
import pgdp.tree.Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Company {

    private Employee CEO;
    private Tree<Integer> employeesTree;
    private Map<Integer,Employee> employees;
    private Queue<Integer> availableIDs;
    private static int availableID = 1;
    private String name;

    public Company(String name, Employee CEO) {
        this.name = name;
        this.CEO = CEO;
        employeesTree = new Tree<>(0);
        availableIDs = new PriorityQueue<>();
        employees = new HashMap<>();
        employees.put(0,CEO);
    }

    public void addEmployee(Employee newEmployee) {
        if(!employeesTree.containsKey(newEmployee.getBoss().getID())) return;
        Integer temp;
        if(availableIDs.isEmpty()) temp = availableID++;
        else temp = availableIDs.remove();
        employees.put(temp, newEmployee);
        employeesTree.insert(temp, newEmployee.getBoss().getID());
    }

    public void fireEmployee(int ID) {
        if(ID != CEO.getID()){
            employeesTree.remove(ID);
            availableIDs.add(ID);
        }
    }

    public Employee findCommonBoss(Employee e1, Employee e2){
        Integer bossID = employeesTree.LCA(e1.getID(),e2.getID());
        if(employees.get(bossID) != null){
            return employees.get(bossID);
        }
        return null;
    }

    public Employee findByID(int ID) {
        if(employees.get(ID) != null){
            return employees.get(ID);
        }
        return null;
    }

}
