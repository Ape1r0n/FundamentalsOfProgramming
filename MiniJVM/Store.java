package MiniJVM;

public class Store extends Instruction{
    private int i;

    public Store(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().setValueAtIndex(i,simulator.getStack().pop());
    }
}