public class StackUnderflowException extends RuntimeException {
    public StackUnderflowException (){
        super("Push method called on a full stack");
    }
}
