
import java.util.*;


public class BasicDoubleLinkedList<T> implements Iterable<T>{
    protected int size; // --> Size of the List
    protected Node first; //--> head represents the first node of the list
    protected Node last; //--> tail represents the last node of the list



    /**
     * Create a double linked list constructor
     */
    public BasicDoubleLinkedList(){
        this.size=0;
        this.first =null;
        this.last =null;

    } //DONE

    /**
     Inner loop class
     */
    public class Node{
        protected T data;
        protected Node previous;//represents the previous node
        protected Node  next; //represents the last node
    //Constructor
        public Node(T data){
            this.data=data;
            this.next=null;
            this.previous=null;
        }

    } //DONE


    //Methods-->

    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return new DoubleLinkedListIterator();
    }// Done

    public class DoubleLinkedListIterator implements ListIterator<T>{

        protected Node currentNode = first;
        protected Node tail;

        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the forward direction. (In other words,
         * returns {@code true} if {@link #next} would return an element rather
         * than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the forward direction
         */
        @Override
        public boolean hasNext() {
            //if the first node is not empty
            if(currentNode==null){
                return false;
            }
            return true;
        }

        /**
         * Returns the next element in the list and advances the cursor position.
         * This method may be called repeatedly to iterate through the list,
         * or intermixed with calls to {@link #previous} to go back and forth.
         * (Note that alternating calls to {@code next} and {@code previous}
         * will return the same element repeatedly.)
         *
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        @Override
        public T next() throws NoSuchElementException {
            if(hasNext()){
                T newNode= currentNode.data;
                currentNode= currentNode.next;
              return newNode;
            }
            throw new NoSuchElementException();
        }

        /**
         * Returns {@code true} if this list iterator has more elements when
         * traversing the list in the reverse direction.  (In other words,
         * returns {@code true} if {@link #previous} would return an element
         * rather than throwing an exception.)
         *
         * @return {@code true} if the list iterator has more elements when
         * traversing the list in the reverse direction
         */
        @Override
        public boolean hasPrevious() {
            //3 cases
                //1 empty linked list -> return false
            if(first== null){
                return false;
            }
                //2 check emptiness first
            else if(currentNode==null){ //not always case
                return true;
            }
                //3 pointing at something

            else if (currentNode.previous!=null)
            {
            return true;
            }
            else
            return false;
        }

        /**
         * Returns the previous element in the list and moves the cursor
         * position backwards.  This method may be called repeatedly to
         * iterate through the list backwards, or intermixed with calls to
         * {@link #next} to go back and forth.  (Note that alternating calls
         * to {@code next} and {@code previous} will return the same
         * element repeatedly.)
         *
         * @return the previous element in the list
         * @throws NoSuchElementException if the iteration has no previous
         *                                element
         */
        @Override
        public T previous() {
            T temp ;
            if(hasPrevious()){
                if(currentNode==null){
                    currentNode=last;
                }
                else{
                    currentNode= currentNode.previous;
                }
                temp = currentNode.data;
                return temp;

            }
            throw new NoSuchElementException();
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #next}. (Returns list size if the list
         * iterator is at the end of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code next}, or list size if the list
         * iterator is at the end of the list
         */
        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        /**
         * Returns the index of the element that would be returned by a
         * subsequent call to {@link #previous}. (Returns -1 if the list
         * iterator is at the beginning of the list.)
         *
         * @return the index of the element that would be returned by a
         * subsequent call to {@code previous}, or -1 if the list
         * iterator is at the beginning of the list
         */
        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        /**
         * Removes from the list the last element that was returned by {@link
         * #next} or {@link #previous} (optional operation).  This call can
         * only be made once per call to {@code next} or {@code previous}.
         * It can be made only if {@link #add} has not been
         * called after the last call to {@code next} or {@code previous}.
         *
         * @throws UnsupportedOperationException if the {@code remove}
         *                                       operation is not supported by this list iterator
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /**
         * Replaces the last element returned by {@link #next} or
         * {@link #previous} with the specified element (optional operation).
         * This call can be made only if neither {@link #remove} nor {@link
         * #add} have been called after the last call to {@code next} or
         * {@code previous}.
         *
         * @param t the element with which to replace the last element returned by
         *          {@code next} or {@code previous}
         * @throws UnsupportedOperationException if the {@code set} operation
         *                                       is not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of the specified
         *                                       element prevents it from being added to this list
         * @throws IllegalStateException         if neither {@code next} nor
         *                                       {@code previous} have been called, or {@code remove} or
         *                                       {@code add} have been called after the last call to
         *                                       {@code next} or {@code previous}
         */
        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();

        }

        /**
         * Inserts the specified element into the list (optional operation).
         * The element is inserted immediately before the element that
         * would be returned by {@link #next}, if any, and after the element
         * that would be returned by {@link #previous}, if any.  (If the
         * list contains no elements, the new element becomes the sole element
         * on the list.)  The new element is inserted before the implicit
         * cursor: a subsequent call to {@code next} would be unaffected, and a
         * subsequent call to {@code previous} would return the new element.
         * (This call increases by one the value that would be returned by a
         * call to {@code nextIndex} or {@code previousIndex}.)
         *
         * @param t the element to insert
         * @throws UnsupportedOperationException if the {@code add} method is
         *                                       not supported by this list iterator
         * @throws ClassCastException            if the class of the specified element
         *                                       prevents it from being added to this list
         * @throws IllegalArgumentException      if some aspect of this element
         *                                       prevents it from being added to this list
         */
        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }// TESTED --> DONE

    /**
     *Adds an element to the end of the list.
     *  Do not use iterators to implement this method.
     * @param data
     * */
    public BasicDoubleLinkedList <T>  addToEnd(T data){
        //Create a node object to be added

        Node newNode= new Node(data);

      if(size==0){
          first = newNode;
          last = first;
      }
      else{
          last.next=newNode;
          newNode.previous=last;
            last= newNode;
      }
      size++;
      return this;
    } // TO TESTED --> DONE

    /**
     * Adds element to the front of the list.
     * Do not use iterators to implement this method.
     * @param data
     * */
    public BasicDoubleLinkedList <T>  addToFront(T data){
        //Create the node object to be added
        Node newNode= new Node(data);
        //Check if the head of the list is equal to null
        if(first ==null){
            //then equal it to the new node we want to add
            first = newNode;
        }
        else{
            newNode.next= first;
            first.previous=newNode;
            first =newNode;
        }
        size++;

        return this;
    } // TESTED --> DONE

    /**
     * Removes and return the 1st element from the list.
     * returns null if no element
     * */
    public T retrieveLastElement(){
        //Create a toDelete variable
        T toDelete= last.data;// --> get last element to be deleted
       if(size==0){
           return null;
       }
      else if(size==1){
           first= null;
           last=null;
            return toDelete;
       }
       else{
           last= last.previous;
           last.next= null;
       }
        size--;
        return toDelete;
    } // TESTED --> DONE

    /**
    * Removes and return the 1st element from the list.
    * returns null if no element
    * */
    public T retrieveFirstElement() {
        //Create a element T to be removed
        T toDelete = first.data; // 1st data
        if(size==0){
            return null;
        }
        else{
            first= first.next;
            first.previous=null;}
        size--;
        return toDelete;

    } //TESTED --> DONE

    /**
 *Removes the first instance of the targetData from the list. Notice that you must remove the elements by performing a single traversal over the list.
 * You may not use any of the other retrieval methods associated with the class in order to complete the removal process.
 *  You must use the provided comparator (do not use equals) to find those elements that match the target.
 *  Do not implement this method using iterators.
 *
 * @param targetData
 * @param comparator
 * @return data element or null
 *
 * */
    BasicDoubleLinkedList<T> remove (T targetData, Comparator<T> comparator){
        Node currNode= first;
        //curr.next.prev=curr.prev
        //curr.prev.next=curr.next
        //If size is equal to 0
        if(size==0){
            return null;
        }
        if(size==1){
            if(comparator.compare(targetData, currNode.data)==0){
            first=null;
            last=null;
            size=0;
            }
            return this;
        }
        while(currNode!=null){
            if(comparator.compare(targetData, currNode.data)==0){//if they are equal
               if(currNode==first) {
                   first=first.next;
               }
               else if(currNode==last){
                   last=last.previous;
               }
               else{
                   currNode.next.previous=currNode.previous;
                   currNode.previous.next= currNode.next;
                }
               size--;
               return this;
            }
            currNode=currNode.next;
        }

        return this;
    } // TESTED --> DONE

    /***Returns an arraylist of the items in the list from head of list to tail of list
     * @return T -> an arrayList of the items in the list
     */
    public ArrayList<T> toArrayList(){
        //Create an arrayList,
        //Loop through the arrayList then add all the node from the 1st to last
        ArrayList<T> myArrayList = new ArrayList<>();
        Node currentNode=first;

    //AskTutor: can we use a for loop here?

        while(currentNode!=null){
            myArrayList.add(currentNode.data);
            currentNode= currentNode.next;
        }
        return myArrayList;
    }// TO TESTED --> DONE
    //END OF METHODS IMPLEMENTED BY MOI.




    //Accessors and mutators --> DONE
    public T getFirst() {
        //If there is no node, there is no head to be returned, else return the head/previous of the node of a specific data
        if(size==0){
            return null;
        }
        return first.data;

    }

    public void setFirst(Node first) {
        this.first = first;
    }

    public T getLast() {
        //If there is no node, there is no tail to be returned, else if there is a node return the tail/next of the node of a specific data
        if(size==0){
            return null;
        }
        return last.data;
    }

    public void setLast(Node last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
