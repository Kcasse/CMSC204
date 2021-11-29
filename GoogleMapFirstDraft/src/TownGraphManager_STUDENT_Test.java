import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TownGraphManager_STUDENT_Test {
    private TownGraphManagerInterface graph;
    private String [] town;

    @Before
    public void setUp () throws Exception{
        graph = new TownGraphManager();
        town= new String[11];


        for (int i = 1; i < 11; i++) {
            town[i] = "Town_" + i;
            graph.addTown(town[i]);
        }

        graph.addRoad(town[1], town[2], 2, "Road_1");
        graph.addRoad(town[1], town[3], 4, "Road_2");
        graph.addRoad(town[1], town[5], 6, "Road_3");
        graph.addRoad(town[3], town[7], 1, "Road_4");
        graph.addRoad(town[3], town[8], 2, "Road_5");
        graph.addRoad(town[4], town[8], 3, "Road_6");
        graph.addRoad(town[6], town[9], 3, "Road_7");
        graph.addRoad(town[9], town[10], 4, "Road_8");
        graph.addRoad(town[8], town[10], 2, "Road_9");
        graph.addRoad(town[5], town[10], 5, "Road_10");
    }

    @After
    public void tearDown() throws Exception{
        graph= null;
    }

    @Test
    public void testAddRoad() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_10", roads.get(1));
        graph.addRoad(town[4], town[10], 1,"Road_13");
        roads = graph.allRoads();
        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_10", roads.get(1));

    }

    @Test
    public void testGetRoad() {
        assertEquals("Road_9", graph.getRoad(town[8], town[10]));
        assertEquals("Road_4", graph.getRoad(town[3], town[7]));
        assertEquals("Road_10",graph.getRoad(town[5],town[10]));
    }

    @Test
    public void testAddTown() {
        assertEquals(false, graph.containsTown("Town_12"));
        graph.addTown("Town_12");
        assertEquals(true, graph.containsTown("Town_12"));
    }


    @Test
    public void testContainsTown() {
        assertEquals(true, graph.containsTown("Town_2"));
        assertEquals(false, graph.containsTown("Town_12"));
        assertEquals(false, graph.containsTown("Town_11"));
    }

    @Test
    public void testContainsRoadConnection() {
        assertEquals(true, graph.containsRoadConnection(town[2], town[1]));
        assertEquals(false, graph.containsRoadConnection(town[3], town[5]));
        assertEquals(true, graph.containsRoadConnection(town[10],town[5]));
    }

    @Test
    public void testAllRoads() {
        ArrayList<String> roads = graph.allRoads();
        assertEquals("Road_1", roads.get(0));
        assertEquals("Road_10", roads.get(1));
        assertEquals("Road_11", roads.get(2));
        assertEquals("Road_8", roads.get(10));
        assertEquals("Road_9", roads.get(11));
    }

    @Test
    public void testDeleteRoadConnection() {
        assertEquals(true, graph.containsRoadConnection(town[2], town[11]));
        graph.deleteRoadConnection(town[2], town[11], "Road_12");
        assertEquals(false, graph.containsRoadConnection(town[2], town[11]));
    }

    @Test
    public void testDeleteTown() {
        assertEquals(true, graph.containsTown("Town_2"));
        graph.deleteTown(town[2]);
        assertEquals(false, graph.containsTown("Town_2"));


        assertEquals(true, graph.containsTown("Town_10"));
        graph.deleteTown(town[10]);
        assertEquals(false, graph.containsTown("Town_10"));
    }

    @Test
    public void testAllTowns() {
        ArrayList<String> roads = graph.allTowns();
        assertEquals("Town_1", roads.get(0));
        assertEquals("Town_10", roads.get(1));


    }



}
