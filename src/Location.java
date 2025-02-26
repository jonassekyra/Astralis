import java.util.Arrays;

public class Location {
    private String name;
    private String[] posibleLocations;

    public Location(String name,String[] posibleLocations) {
        this.name = name;
        this.posibleLocations = posibleLocations;
    }

    public String[] getPosibleLocations() {
        return posibleLocations;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", posibleLocations=" + Arrays.toString(posibleLocations) +
                '}';
    }
}
