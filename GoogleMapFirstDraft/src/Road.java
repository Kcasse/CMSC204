import java.util.Objects;

/**@author Khar
 * Description: The class Road that can represent the edges of a Graph of Towns.
 * The class must implement Comparable. The class stores references to the two vertices(Town endpoints),
 * the distance between vertices, and a name, and the traditional methods (constructors, getters/setters, toString, etc.),
 * and a compareTo, which compares two Road objects. Since this is a undirected graph, an edge from A to B is equal to an edge from B to A.
 *
 * */
//EDGE==ROAD

public class Road implements Comparable<Road> {
    protected Town source;
    protected Town destination;
    protected int weight;
    protected String name;

    public Road(Town source, Town destination, int degrees, String name){
        this.source=source;
        this.destination=destination;
        this.weight=degrees;
        this.name = name;

    }
    public Road(Town source, Town destination, String name){
        weight=1;
        this.source=source;
        this.destination=destination;
        this.name = name;

    }

    /**
     * @param town
     * Returns true only if the edge contains the given town
     * */

    public boolean contains(Town town){
        if(source.getName().equals(town.getName())|| destination.getName().equals(town.getName())){
            return true;
        }

        return false;
    }

    @Override
    public boolean equals(Object r) {
        Road road = (Road) r;
        if((source.equals(road.source) && destination.equals(road.destination)) || (source.equals(road.destination) && destination.equals(road.source))){
            return true;
        }
        return false;
    }


    @Override
    public int hashCode() {
        return Objects.hash(getSource(), getDestination());
    }



    @Override
    public int compareTo(Road r) {
       return this.name.compareTo(r.name);
    }

    public Town getSource() {
        return source;
    }

    public Town getDestination() {
        return destination;
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Road: " +
                "source=" + source +
                ", destination=" + destination +
                ", weight=" + weight +
                ", name="+ name ;
    }
}
