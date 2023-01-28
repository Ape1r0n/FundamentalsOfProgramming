package MiniJVM;

public class Sub extends Instruction{
    public void execute(Simulator simulator){
        if(!simulator.isHalted()) simulator.getStack().push((-1)*simulator.getStack().pop()+simulator.getStack().pop());
    }
}