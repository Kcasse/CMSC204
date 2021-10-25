
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
/**
 * This is the test file for the CourseDBManager
 * which is implemented from the CourseDBManagerInterface
 *
 * @author Khar
 *
 */
public class CourseDBManager_STUDENT_Test {
    private CourseDBManagerInterface dataManager = new CourseDBManager();
    /**
     * Create an instance of CourseDBManager
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception{
        dataManager = new CourseDBManager();
    }

    /**
     * Set dataManager reference to null
     * @throws Exception
     * */
    @After
    public void tearDown () throws Exception{
        dataManager=null;
    }
    /**
     * Test for the add method
     * */
    @Test
    public void testAddToDB(){
            try{
                dataManager.add("CMSC203",30550,4,"SC300","iAmTheProf");

        }catch(Exception e){
                fail("This should not have caused an Exception");
            }
    }
    /**
     * Test for the showAll method
     */

    @Test
    public void testShowAll(){
        dataManager.add("CMSC207",21485,4,"SC207","Dr.Discrete Math");
        dataManager.add("CMSC204",21479,4,"SC204","Dr.Data Structure");
        dataManager.add("CMSC269",22442,1,"SC269","Dr.Intern Ship");


        ArrayList<String> list = dataManager.showAll();

        assertEquals(list.get(0),"\nCourse:CMSC207 CRN:21485 Credits:4 Instructor:Dr.Discrete Math Room:SC207");
        assertEquals(list.get(1),"\nCourse:CMSC204 CRN:21479 Credits:4 Instructor:Dr.Data Structure Room:SC204");
        assertEquals(list.get(2),"\nCourse:CMSC269 CRN:22442 Credits:1 Instructor:Dr.Intern Ship Room:SC269");

    }

    /**
     * Test for the read method
     */
    @Test
    public void testRead(){
        try{
            File inputFile = new File("Test2.txt");
            PrintWriter inFile = new PrintWriter(inputFile);
            inFile.println("CMSC207 21485 4 Dr. Discrete Math CS207a");
            inFile.print("CMSC207 21486 4 Dr. Discrete Mathematics CS207b");
            inFile.close();
            dataManager.readFile(inputFile);
        }catch(Exception e){
            fail("Should not have thrown an exception");
        }
    }







}
