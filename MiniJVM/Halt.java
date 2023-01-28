package MiniJVM;

public class Halt extends Instruction{
    public void execute(Simulator simulator){

        if(!simulator.isHalted()) simulator.setHalted(true);
    }
}