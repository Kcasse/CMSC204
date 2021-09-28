import java.util.ArrayList;
//QUEUE=> FIFO-> First in, first out
//DONE=> implemented and pass Junit test
/**
 * @author Khar
 * */
public class NotationQueue <T>implements QueueInterface<T> {

 //FIELDS
    int size;
    private ArrayList<T> element;

 //CONSTRUCTORS


    public NotationQueue() {
        this.element = new ArrayList<>(size);
    }
    public NotationQueue(int size){
     this.size= size;
     this.element= new ArrayList<>(size);

    }

    /**
     * Determines if Queue is empty
     *
     * @return true if Queue is empty, false if not
     */
    @Override
    public boolean isEmpty() {
       if(element.size()==0){
           return true;
       }
       else{
           return false;
       }
    } //DONE

    /**
     * Determines of the Queue is empty
     *
     * @return
     */
    @Override
    public boolean isFull() {
        if(element.size()==size){
            return true;

        }
        else{
            return false;
        }

    } //DONE

    /**
     * Deletes and returns the element at the front of the Queue
     *
     * @return the element at the front of the Queue
     */
    @Override
    public T dequeue() throws QueueUnderflowException {
        if (element.size()==0){
            throw new QueueUnderflowException();
        }

            return element.remove(0);

    }//DONE

    /**
     * Number of elements in the Queue
     *
     * @return the number of elements in the Queue
     */
    @Override
    public int size() {

        return element.size();
    } //DONE


    /**
     * Adds an element to the end of the Queue
     *
     * @param e the element to add to the end of the Queue
     * @return true if the add was successful, false if not
     */
    @Override
    public boolean enqueue(T e) throws QueueOverflowException {
        //if the queue is full throw exception
        if(element.size()==size){
            throw new QueueOverflowException();
        }
        element.add(e);
        return true;
    } //DONE

    /**
     * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
     * Place the delimiter between all elements of the Queue
     *
     * @param delimiter
     * @return string representation of the Queue with elements separated with the delimiter
     */
    @Override
    public String toString(String delimiter) {
        //create a string
        String string ="";
        for(T looper: element){
            string+=looper+delimiter;
        }
        string= string.substring(0,string.length()-1);
        return string;
    } //DONE

    public String toString (){
        String finalString="";
        for(T element2 : element){
          finalString+=element2;
        }
        return finalString;
    } //DONE
    /**
     * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
     * is the first element in the Queue
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE QUEUE, if you use the
     * list reference within your Queue, you will be allowing direct access to the data of
     * your Queue causing a possible security breech.
     *
     * @param list elements to be added to the Queue
     */
    @Override
    public void fill(ArrayList <T> list) {

        //For each loop to go through the arrayList
        //Add/enqueue every element from list to our queue
        for(T element2: list)
            {
            enqueue(element2);
                }

    }
}
