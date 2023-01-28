package MiniJVM;

public class Alloc extends Instruction{
    private int i;
    public Alloc(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().alloc(i);
    }
}