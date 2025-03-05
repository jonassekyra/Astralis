package Player;

import java.util.ArrayList;

public class Backpack {
    private ArrayList<Item> myItems;
    private ArrayList<Item> allItems;

    public Backpack() {
        myItems = new ArrayList<Item>();
        allItems = new ArrayList<Item>();
    }
    public boolean loadItems() {
        return true;
    }

    public boolean removeItem(String Item) {
        return true;

    }

    public boolean addToMyItem(String Item) {
        return true;
    }
}
