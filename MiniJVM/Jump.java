package MiniJVM;

public class Jump extends Instruction{
    private int i;

    public Jump(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.setProgramCounter(i);
    }
}