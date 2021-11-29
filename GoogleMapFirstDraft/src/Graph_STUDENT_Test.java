import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Graph_STUDENT_Test {
    private GraphInterface<Town,Road> graph;
    private Town[] town;

    @Before
    public void setUp() throws Exception{

        graph= new Graph();
        town= new Town[11];
        for(int i=1; i< town.length;i++){
            town[i]= new Town("Town_" +i);
            graph.addVertex(town[i]);
        }

        System.out.println("All town has been added");
        graph.addEdge(town[1], town[2], 2, "Road_1");
        graph.addEdge(town[1], town[3], 4, "Road_2");
        graph.addEdge(town[1], town[5], 6, "Road_3");
        graph.addEdge(town[3], town[7], 1, "Road_4");
        graph.addEdge(town[3], town[8], 2, "Road_5");
        graph.addEdge(town[4], town[8], 3, "Road_6");
        graph.addEdge(town[6], town[9], 3, "Road_7");
        graph.addEdge(town[9], town[10], 4, "Road_8");
        graph.addEdge(town[8], town[10], 2, "Road_9");
        graph.addEdge(town[5], town[10], 5, "Road_10");
    }

    @After
    public void tearDown() throws Exception{
        graph= null;
    }

    @Test
    public void testGetEdge() {
        assertEquals(new Road(town[1], town[2],2, "Road_1"), graph.getEdge(town[1], town[2]));
        assertEquals(new Road(town[3], town[7],1, "Road_4"), graph.getEdge(town[3], town[7]));
    }
    @Test
    public void testAddEdge() {
        assertEquals(false, graph.containsEdge(town[3], town[5]));
        graph.addEdge(town[3], town[5], 1, "Road_13");
        assertEquals(true, graph.containsEdge(town[3], town[5]));
    }

    @Test
    public void testAddVertex(){
        assertEquals(false, graph.containsEdge(town[5],town[2]));
        assertEquals(true, graph.containsEdge(town[10],town[5]));

    }
    @Test
    public void testContainsVertex(){
        assertEquals(true, graph.containsVertex(new Town("Town_10")));
        assertEquals(false, graph.containsVertex(new Town("Town_11")));
    }

    @Test
    public void testEdgeSet(){
         Set<Road> roads= graph.edgeSet();
         ArrayList<String> roadArrayList = new ArrayList<>();
         for(Road r: roads){
             roadArrayList.add(r.getName());
         }
        Collections.sort(roadArrayList);
        assertEquals("Road_1", roadArrayList.get(0));
        assertEquals("Road_10", roadArrayList.get(1));
    }
    @Test
    public void testEdgesOf() {
        Set<Road> roads = graph.edgesOf(town[1]);
        ArrayList<String> roadArrayList = new ArrayList<String>();
        for(Road road : roads)
            roadArrayList.add(road.getName());
        Collections.sort(roadArrayList);
        assertEquals("Road_1", roadArrayList.get(0));
        assertEquals("Road_2", roadArrayList.get(1));
        assertEquals("Road_3", roadArrayList.get(2));
    }

    @Test
    public void testRemoveEdge() {
        assertEquals(true, graph.containsEdge(town[1], town[5]));
        graph.removeEdge(town[1], town[5], 6, "Road_3");
        assertEquals(false, graph.containsEdge(town[1], town[5]));
    }


    @Test
    public void testRemoveVertex() {
        assertEquals(true, graph.containsVertex(town[2]));
        graph.removeVertex(town[2]);
        assertEquals(false, graph.containsVertex(town[2]));
    }

    @Test
    public void testVertexSet() {
        Set<Town> roads = graph.vertexSet();
        assertEquals(true,roads.contains(town[1]));
        assertEquals(true, roads.contains(town[10]));
        assertEquals(true, roads.contains(town[2]));
        assertEquals(true, roads.contains(town[3]));
    }

    //Others tests are not implemented because the method(ShortestPath) is not implemented













}
