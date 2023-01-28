package pgdp.penguinDate;
import pgdp.tree.Tree;

public class DateSimulator {
    public static void main(String[] args) {
        simulation();

    }
    private static void simulation() {
        Penguin adam = new Penguin("Adam",10);
        Penguin michael = new Penguin("Michael", "Adam", 0);
        Penguin robin = new Penguin("Robin", "Adam", 2);
        Penguin dwight = new Penguin("Dwight","Adam",5);
        Penguin phoebe = new Penguin("Phoebe", "Michael",3);
        Penguin levi = new Penguin("Levi", "Phoebe",1);
        Penguin ted = new Penguin("Ted","Robin",2);
        Penguin hange = new Penguin("Hange","Robin",2);
        Penguin jim = new Penguin("Jim","Ted",3);
        Penguin rachel = new Penguin("Rachel","Jim",2);

        Tree<Penguin> tree = new Tree<>(adam);
        tree.insert(michael,adam);
        tree.insert(robin,adam);
        tree.insert(dwight,adam);
        tree.insert(phoebe,michael);
        tree.insert(levi,phoebe);
        tree.insert(ted,robin);
        tree.insert(hange,robin);
        tree.insert(jim,ted);
        tree.insert(rachel,jim);
        PenguinDateGenerator generator = new PenguinDateGenerator(tree);
        System.out.println(generator.canGoOnADate(levi,hange)); // true
        System.out.println(generator.canGoOnADate(phoebe,adam)); // false
        System.out.println(generator.canGoOnADate(jim,dwight)); // false
        System.out.println(generator.canGoOnADate(ted,robin)); // false
        System.out.println(generator.canGoOnADate(rachel,michael)); // true

    }

}
