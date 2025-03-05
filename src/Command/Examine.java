package Command;
import Player.Item;
import World.NPC;
import java.util.ArrayList;
import java.util.HashSet;

public class Examine implements Command{



    @Override
    public String execute() {
        return "";
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
