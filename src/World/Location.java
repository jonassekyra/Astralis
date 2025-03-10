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

    public Location(String name, String[] posibleLocations, ArrayList<Item> items) {
        this.name = name;
        this.posibleLocations = posibleLocations;
        this.items = items;
    }

    public String[] getPosibleLocations() {
        return posibleLocations;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", posibleLocations=" + Arrays.toString(posibleLocations) +
                ", items=" + items+
                '}';
    }
}
