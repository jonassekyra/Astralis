import java.util.Arrays;

public class Location {
    private String[] posibleLocations;

    public Location(String[] posibleLocations) {
        this.posibleLocations = posibleLocations;
    }

    @Override
    public String toString() {
        return "Location{" +
                "posibleLocations=" + Arrays.toString(posibleLocations) +
                '}';
    }
}
