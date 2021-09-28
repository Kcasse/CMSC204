import java.util.ArrayList;
//Stack == LIFO--> Last In First Out

public class NotationStack <T> implements StackInterface<T>{
    //FIELDS
    int size;
    private ArrayList<T> element;



    //CONSTRUCTORS


    public NotationStack() {
        this.element= new ArrayList<>(size);
    }
    public NotationStack(int size){
        this.size=size;
        this.element= new ArrayList<>(size);

    }

    /**
     * Determines if Stack is empty
     *
     * @return true if Stack is empty, false if not
     *
     */

    @Override
    public boolean isEmpty() {
        if (element.size()== 0){
            return true;
        }
        else {
            return false;}

    }//DONE

    /**
     * Determines if Stack is full
     *
     * @return true if Stack is full, false if not
     */
    @Override
    public boolean isFull() {
        if (element.size()==size){
            return true;
        }
        else
        {
            return false;
        }

    }//DONE

    /**
     * Deletes and returns the element at the top of the Stack
     *
     * @return the element at the top of the Stack
     */
    @Override
    public T pop() throws StackUnderflowException {
        if(size()==0){
            throw new StackUnderflowException();
        }
        return element.remove(element.size()-1);
    } //DONE

    /**
     * Returns the element at the top of the Stack, does not pop it off the Stack
     *
     * @return the element at the top of the Stack
     */
    @Override
    public T  top() throws StackUnderflowException {
        if(element.size()==0){
            throw new StackUnderflowException();
        }
        return element.get(element.size()-1);

    } //DONE

    /**
     * Number of elements in the Stack
     *
     * @return the number of elements in the Stack
     */
    @Override
    public int size() {
        return element.size();
    } //DONE

    /**
     * Adds an element to the top of the Stack
     *
     * @param e the element to add to the top of the Stack
     * @return true if the add was successful, false if not
     */
    @Override
    public boolean push(T e) throws StackOverflowException {
        if(element.size()==size){
            throw new StackOverflowException();
        }
        else
        {
            element.add(e);
            return true;
        }

    } //DONE


    /**
     * Returns the string representation of the elements in the Stack, the beginning of the
     * string is the bottom of the stack
     * Place the delimiter between all elements of the Stack
     *
     * @param delimiter
     * @return string representation of the Stack from bottom to top with elements
     * separated with the delimiter
     */
    @Override
    public String toString(String delimiter) {
        String finalString= "";
        //We are going to loop through the arrayList with a for loop and add every single element to the
        for(T elementLoop : element){
            finalString+=elementLoop+delimiter;
        }
        //removing the last delimiter
        finalString= finalString.substring(0,finalString.length()-1);
        return finalString;
    }

    public String toString(){
        String finalString="";
        for(T arrayList: element){
            finalString+= arrayList;
        }
        return finalString;
    }
    /**
     * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
     * is the first bottom element of the Stack
     * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
     * list reference within your Stack, you will be allowing direct access to the data of
     * your Stack causing a possible security breech.
     *
     * @param list elements to be added to the Stack from bottom to top
     */
    @Override
    public void fill(ArrayList <T>list) {
        //For each loop to go through the arrayList
        //Add/enqueue every element from list to our stack
       for(T ListElement: list)
       {
           this.push(ListElement);
       }

    }
}