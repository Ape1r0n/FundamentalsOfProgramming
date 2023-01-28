package MiniJVM;

public class Main {
    public static void main(String[] args) {
        Instruction[] code = new Instruction[]{
                //The program calculates the sum of the whole numbers from 1 to 5
                new Alloc(2),
                new Const(0),
                new Store(0),
                new Const(5),
                new Store(1),
                new Const(0),
                new Load(1),
                new Less(),
                new FJump(18),
                new Load(0),
                new Load(1),
                new Add(),
                new Store(0),
                new Load(1),
                new Const(1),
                new Sub(),
                new Store(1),
                new Jump(5),
                new Halt()};
        Simulator simulator = new Simulator(5, code);
        simulator.executeInstructions();
        System.out.println(simulator.getStack());
    }
}
