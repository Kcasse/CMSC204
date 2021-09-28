public class QueueOverflowException extends RuntimeException{
    QueueOverflowException(){
        super("dequeue method called on a empty queue");

    }
}
