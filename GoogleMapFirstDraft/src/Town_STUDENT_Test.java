import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Town_STUDENT_Test {
    
    private Town town1, town2;
    
    @Before
  public void setUp () throws Exception{
        town1= new Town("Town1");
        town2= new Town("Town2");
    }
    
  @After
  public void tearDown() throws Exception{
        town1=town2=null;
        
  }  


    @Test
    public void testHashCode() {
        assertEquals(town1.hashCode(), new Town("Town1").hashCode(),0.001);
        assertNotEquals(town1.hashCode(), new Town("Town2").hashCode());
    }

    @Test
    public void testCompareTo() {
        assertEquals(0, town1.compareTo(town1));
        assertEquals(0, town1.compareTo(new Town("Town1")));
        assertEquals(-1, town1.compareTo(town2));
    }

    @Test
    public void testEqualsObject() {
        assertEquals(true, town1.equals(town1));
        assertEquals(true, town1.equals(new Town("Town1")));
        assertEquals(false, town1.equals(town2));
    }

    @Test
    public void testGetName() {
        assertEquals("Town1", town1.getName());
        assertEquals("Town2", town2.getName());
    }

    @Test
    public void testToString() {
        assertEquals("Town1", town1.toString());
        assertEquals("Town2", town2.toString());
    }

}
