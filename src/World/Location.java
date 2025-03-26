package World;
import Player.Item;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Location {
    private String name;
    private String[] posibleLocations;
    private ArrayList<Item> items;
    private HashSet<NPC> NPCS;
    private boolean isExamined = false;


    public Location(String name, String[] posibleLocations, ArrayList<Item> items, HashSet<NPC> NPCS) {
        this.name = name;
        this.posibleLocations = posibleLocations;
        this.items = items;
        this.NPCS = NPCS;
    }

    public String[] getPosibleLocations() {
        return posibleLocations;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public HashSet<NPC> getNPCS() {
        return NPCS;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", posibleLocations=" + Arrays.toString(posibleLocations) +
                ", items=" + items +
                ", NPCS=" + NPCS +
                '}';
    }

    public boolean isExamined() {
        return isExamined;
    }

    public void setExamined(boolean examined) {
        isExamined = examined;
    }
}
