
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Road_STUDENT_Test {
    private Road road1, road2;
    private Town town1,town2, town3;


    @Before
    public void setUp() throws Exception{
        town1= new Town("town1");
        town2 = new Town("town2");
        town3 = new Town("town3");

        road1= new Road(town1,town2,2000,"Road1");
        road2 = new Road(town2,town1,2000,"Road2");
    }

    @After
    public void tearDown() throws Exception{
        road1=road2=null;
        town1=town2=town3=null;
    }
    @Test
    public void testContains(){
        assertEquals(true,road1.contains(town1));
        assertEquals(false,road1.contains(town3));
        assertEquals(true,road2.contains(town2));
    }
    @Test
    public void testGetDestination(){
        assertTrue(road1.getSource()==town1);
        assertTrue(road2.getDestination()==town1);
    }

    @Test
    public void testCompareTo(){
        assertEquals(0,road1.compareTo(road1));
        assertEquals(-1,road1.compareTo(road2));
    }
    @Test
    public void testEquals(){
        assertTrue(road1.equals(new Road(town1,town2,2000,"Road1")));
        assertFalse(road1.equals(road2)==false);
    }
    @Test
    public void testGetName(){
        assertEquals("Road1",road1.getName());
        assertEquals("Road2", road2.getName());
    }
    @Test
    public void testToString(){
        System.out.println(road1.toString());
        assertEquals("Road: source=town1, destination=town2, weight=2000, name=Road1",road1.toString());
        assertEquals("Road: source=town2, destination=town1, weight=2000, name=Road2",road2.toString());

    }
}
