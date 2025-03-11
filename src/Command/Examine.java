package Command;
import Player.Item;
import World.NPC;
import World.WorldMap;

import java.util.ArrayList;
import java.util.HashSet;

public class Examine implements Command{
    private WorldMap worldMap;

    public Examine(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {
        if (!worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            worldMap.locations.get(worldMap.getCurrentPosition()).setExamined(true);
            return "you found: " + worldMap.locations.get(worldMap.getCurrentPosition()).getItems();

        }else {
            return "allready examined";
        }

    }

    @Override
    public boolean exit() {
        return false;
    }

    public ArrayList<Item> exemineItem(){
        return null;
    }
    public HashSet<NPC> exemineNPC(){
        return null;
    }

}
