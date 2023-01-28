package MiniJVM;

public class Less extends Instruction{
    public void execute(Simulator simulator){
        if(!simulator.isHalted()){
            int temp = simulator.getStack().pop();
            if(temp > simulator.getStack().pop()) simulator.getStack().push(1);
            else simulator.getStack().push(0);
        }
    }
}