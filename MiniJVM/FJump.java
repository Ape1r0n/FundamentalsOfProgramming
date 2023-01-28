package MiniJVM;

public class FJump extends Instruction{
    private int i;

    public FJump(int i){
        this.i = i;
    }

    public void execute(Simulator simulator){
        if(!simulator.isHalted()){
            int temp = simulator.getStack().pop();
            if(temp == 0) simulator.setProgramCounter(i);
        }
    }
}