package ThreadPools;

public class ShutDownException extends Exception{
    public ShutDownException(){
        super("Shutdown...");
    }
}