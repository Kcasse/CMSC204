import java.util.Comparator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
/**
 * Creates an empty list that is associated with the specified comparator.
 * @param <T>
 * */
    public class SortedDoubleLinkedList <T> extends BasicDoubleLinkedList<T> implements Iterable<T>{
        Comparator<T> comparator;


        /**Creates an empty list that is associated
         * with the specified comparator.
         * @param comparator2
         * */
    public SortedDoubleLinkedList(Comparator<T> comparator2){
        this.comparator=comparator2;
    }

    public SortedDoubleLinkedList<T> add(T data){
        Node current = first;
        Node newNode=new Node(data);
        //If the list is empty
        if(first==null){
            first=newNode;
            last=first;
            size++;
            return this;
        }
        //Adding before the 1st element
        if(comparator.compare(first.data,data)>0 )
        {
            newNode.next = first;
            first.previous = newNode;
            first = newNode;
            size++;
            return this;
        }


        while(comparator.compare(current.data,data)<0 ){
            if(current.next==null){
                current.next=newNode;
                newNode.previous=current;
                last=newNode;
                size++;
                return this;
            }
            current=current.next;//update
        }
        //Adding in the middle between head and tail
        current.previous.next=newNode;
        newNode.previous=current.previous;
        current.previous= newNode;
        newNode.next=current;
        size++;
        return this;


    }//BLOCK-PRIORITY W/ TUTOR

    @Override
    public BasicDoubleLinkedList addToFront(T data) {

        throw new UnsupportedOperationException();
    }//DONE

    @Override
    public BasicDoubleLinkedList addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Invalid operation for sorted list");
    }//DONE


    /**
     * Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list.
     * You may not use any of the other retrieval methods associated with the class in order to complete the removal process.
     * You must use the provided comparator (do not use equals) to find those elements that match the target.
     * Do not implement this method using iterators.
     *
     * @param targetData
     * @param comparator
     * @return data element or null
     */
    @Override
   SortedDoubleLinkedList remove(T targetData, Comparator <T>comparator) {

        return (SortedDoubleLinkedList) super.remove(targetData, comparator);
    }//DONE

    @Override
    public java.util.ListIterator<T> iterator(){
        return super.iterator();
    }//DONE


}
