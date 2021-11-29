import java.io.*;
import java.util.*;

public class TownGraphManager implements TownGraphManagerInterface{

    protected Graph graph;

    public TownGraphManager(){
        graph= new Graph();
    }

    /**
     * Adds a road with 2 towns and a road name
     *
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param weight
     * @param roadName name of road
     * @return true if the road was added successfully
     */
    @Override
    public boolean addRoad(String town1, String town2, int weight, String roadName) {
        if(graph.addEdge(new Town(town1),new Town(town2),weight,roadName)!= null){
            return true;
        }
        return false;
    }

    /**
     * Returns the name of the road that both towns are connected through
     *
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return name of road if town 1 and town2 are in the same road, returns null if not
     */
    @Override
    public String getRoad(String town1, String town2) {

            return graph.getEdge(new Town(town1),new Town(town2)).getName();

    }

    /**
     * Adds a town to the graph
     *
     * @param v the town's name  (lastname, firstname)
     * @return true if the town was successfully added, false if not
     */
    @Override
    public boolean addTown(String v) {
        if(graph.addVertex(new Town(v))){
            return true;
        }
        return false;
    }

    /**
     * Gets a town with a given name
     *
     * @param name the town's name
     * @return the Town specified by the name, or null if town does not exist
     */
    @Override
    public Town getTown(String name) {
        if(graph.containsVertex(new Town(name))){
            return getTown(name);
        }
        else return null;

    }

    /**
     * Determines if a town is already in the graph
     *
     * @param v the town's name
     * @return true if the town is in the graph, false if not
     */
    @Override
    public boolean containsTown(String v) {
        if(graph.containsVertex(new Town(v))){
            return true;
        }
        return false;
    }

    /**
     * Determines if a road is in the graph
     *
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return true if the road is in the graph, false if not
     */
    @Override
    public boolean containsRoadConnection(String town1, String town2) {
        if(graph.containsEdge(new Town(town1),new Town(town2))){
            return true;
        }
        return false;
    }

    /**
     * Creates an arraylist of all road titles in sorted order by road name
     *
     * @return an arraylist of all road titles in sorted order by road name
     */
    @Override
    public ArrayList<String> allRoads() {
        ArrayList<String> listOfRoads = new ArrayList<>();
        for(Road road: graph.roadSet){
            listOfRoads.add(road.getName());
        }
       // System.out.println(listOfRoads);
       Collections.sort(listOfRoads);
        return listOfRoads;

    }

    /**
     * Deletes a road from the graph
     *
     * @param town1    name of town 1 (lastname, firstname)
     * @param town2    name of town 2 (lastname, firstname)
     * @param roadName the road name
     * @return true if the road was successfully deleted, false if not
     */
    @Override
    public boolean deleteRoadConnection(String town1, String town2, String roadName) {
        if(graph.removeEdge(new Town(town1), new Town(town2),0,roadName)!= null){
            return true;
        }
        return false;
    }

    /**
     * Deletes a town from the graph
     *
     * @param v name of town (lastname, firstname)
     * @return true if the town was successfully deleted, false if not
     */
    @Override
    public boolean deleteTown(String v) {
        if(graph.removeVertex(new Town(v))){
            return true;
        }
        return false;

    }

    /**
     * Creates an arraylist of all towns in alphabetical order (last name, first name)
     *
     * @return an arraylist of all towns in alphabetical order (last name, first name)
     */
    @Override
    public ArrayList<String> allTowns() {
        ArrayList<String> listOfTowns= new ArrayList<>();
        for (Town town: graph.townSet){
            listOfTowns.add(town.getName());
        }
        Collections.sort(listOfTowns);
        return listOfTowns;

    }

    /**
     * Returns the shortest path from town 1 to town 2
     *
     * @param town1 name of town 1 (lastname, firstname)
     * @param town2 name of town 2 (lastname, firstname)
     * @return an Arraylist of roads connecting the two towns together, null if the
     * towns have no path to connect them.
     */
    @Override
    public ArrayList<String> getPath(String town1, String town2) {
        return graph.shortestPath(new Town(town1), new Town(town2));
    }

    public void populateTownGraph(File selectedFile) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader(selectedFile));
        String st;
        while((st= br.readLine())!= null){
            System.out.println(st);
        }
        br.close();
    }
}
