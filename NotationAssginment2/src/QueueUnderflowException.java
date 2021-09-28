public class QueueUnderflowException extends  RuntimeException{
public QueueUnderflowException(){
    super(" enqueue method called on a full queue");
}
}

