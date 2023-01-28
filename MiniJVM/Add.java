package MiniJVM;

public class Add extends Instruction{
    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().push(simulator.getStack().pop()+simulator.getStack().pop());
    }
}