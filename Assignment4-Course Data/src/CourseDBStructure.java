import java.io.IOException;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
    //Array of LinkedList of CourseDBElements, this represents our hashTable
    LinkedList<CourseDBElement> [] hashTable;



    //Create 2  constructors

    public CourseDBStructure(int i){
      hashTable= new LinkedList[i];
      for(int k=0; k<i;k++){
          //array[k] == to a new linked list
          hashTable[k]= new LinkedList<CourseDBElement>();
      }
    }
    public CourseDBStructure(String name, int i){
        hashTable= new LinkedList[i];
        for(int j =0; j<i ; j++){
            hashTable[j]= new LinkedList<CourseDBElement>();
        }
    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     * <p>
     * If the CourseDatabaseElement does not exist in the hashtable,
     * add it to the hashtable.
     *
     * @param element the CDE to be added
     */
    @Override
    public void add(CourseDBElement element) {

        int index= element.hashCode()% hashTable.length;
        //if the hashtable is n
        if(hashTable[index]==null){
            //Array at index => to a new linkedList of courseElement.
            hashTable[index]= new LinkedList<CourseDBElement>();
            hashTable[index].add(element);
        }
        //Else just add it
         else{
             hashTable[index].add(element);

        }
    }

    /**
     * Use the hashcode of the CourseDatabaseElement to see if it is
     * in the hashtable.
     * <p>
     * If the CourseDatabaseElement is in the hashtable, return it
     * If not, throw an IOException
     *
     * @param crn --> typo ask prof.Alexander (element) the CDE to be added
     * @throws IOException
     */
    @Override
    public CourseDBElement get(int crn) throws IOException {
        String CRNstring= String.valueOf(crn);
        int hashcode= CRNstring.hashCode();
        int index= hashcode% hashTable.length;

       for(int i=0; i< hashTable[index].size();i++){
            if(hashTable[index].get(i).getCRN()== crn){
                return hashTable[index].get(i);
            }

       }

         throw new IOException();
    }

    /**
     * Returns the size of the ConcordanceDataStructure (number of indexes in the array)
     */
    @Override
    public int getTableSize() {
        return hashTable.length;
    }//DONE




}
