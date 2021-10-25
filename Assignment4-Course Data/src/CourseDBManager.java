import javax.imageio.IIOException;
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class CourseDBManager implements CourseDBManagerInterface{
   public CourseDBStructure CDS = new CourseDBStructure(40);



    @Override
    public void add(String id, int crn, int credits, String roomNum, String instructor) {
        //Adding in the courseDBStructure a new course element
        CDS.add(new CourseDBElement(id,crn,credits,roomNum,instructor));
    }

    @Override
    public CourseDBElement get(int crn) {
        try{
            return CDS.get(crn);
        }
       catch (IOException E){
            return null;
       }
    }

    @Override
    public void readFile(File input) throws FileNotFoundException {

       try{
           BufferedReader bufferedReader = new BufferedReader(new FileReader(input));
           String reader;
           while((reader= bufferedReader.readLine())!=null){
               System.out.println(reader);
               //String.split methods can be also used
           }
       }catch (Exception e){
           return;
       }

    }

    @Override
    public ArrayList<String> showAll() {
        ArrayList<String> ListOfCourse = new ArrayList<String>();
        //traverse the linkedList of courses
        for(LinkedList<CourseDBElement> c: CDS.hashTable){//array
            for(Object l: c.toArray()){
                ListOfCourse.add(((CourseDBElement)l).toString());
            }

        }
        return ListOfCourse;
    }
}
