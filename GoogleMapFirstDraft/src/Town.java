import java.util.Objects;
//VERTEX==TOWN
public class Town implements Comparable<Town>{

    private String name;


    public Town(String name){
        this.name = name;

    }
    public Town(Town templateTown){

    name = templateTown.name;
    }

    @Override
    public int compareTo(Town t) {

       return this.name.compareTo(t.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town town = (Town) o;
        return Objects.equals(name, town.name);
    }

    public int hashCode(){

        return name.hashCode();
    }

    @Override
    public String toString() {
        return name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
