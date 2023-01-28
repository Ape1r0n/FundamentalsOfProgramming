package MiniJVM;

public class Const extends Instruction{
    private int i;

    public Const(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().push(i);
    }
}