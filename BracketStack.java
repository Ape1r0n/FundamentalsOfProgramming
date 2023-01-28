public class BracketStack {
    private char[] stack;
    private int stackpointer;

    public BracketStack(int size){
        stack = new char[size];
        stackpointer = -1;
    }

    public void push(char element) {
        if(stackpointer != stack.length-1) stack[++stackpointer] = element;
        else System.out.println("Maximum stack size reached");
    }

    public char pop() {
        return stack[stackpointer--];
    }

    public char peek() {
        return stack[stackpointer];
    }

    public boolean isEmpty(){
        return stackpointer == -1;
    }

    public static char findClosing(char c){
        if (c == '(')
            return ')';
        if (c == '{')
            return '}';
        if (c == '[')
            return ']';
        return Character.MIN_VALUE;
    }

    public static boolean checkBraces(String input){
        if(input.length() % 2 == 1)
            return false;
        else{
            boolean res = true;
            for(int i = 0; i < input.length(); i++){
                if(input.charAt(i) != ')' && input.charAt(i) != '}' && input.charAt(i) != ']'){
                    for(int j = 0; j < input.length(); j++){
                        if(findClosing(input.charAt(i)) == Character.MIN_VALUE){
                            res = false;
                            break;
                        }
                    }
                }
                if(!res){
                    break;
                }
            }
            return res;
        }
    }
}