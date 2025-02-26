package World;

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

}
