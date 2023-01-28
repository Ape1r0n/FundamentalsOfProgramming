package MiniJVM;

public class Load extends Instruction{
    private int i;

    public Load(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().push(simulator.getStack().getValueAtIndex(i));
    }
}