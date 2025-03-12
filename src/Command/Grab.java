package Command;
import Player.Item;
import Player.Player;
import World.WorldMap;

import java.util.Scanner;

public class Grab implements Command {
    private WorldMap worldMap;
    private final Player p;
    Scanner sc = new Scanner(System.in);

    public Grab(WorldMap worldMap, Player p) {
        this.worldMap = worldMap;
        this.p = p;
    }

    @Override
    public String execute() {
        Item input = new Item(sc.nextLine());
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            if (worldMap.locations.get(worldMap.getCurrentPosition()).getItems().contains(input)) {
                p.addItem(input);
                worldMap.locations.get(worldMap.getCurrentPosition()).getItems().remove(input);
        }

        }else {
            return "you haven't examined this location";
        }
        return " items: "+ p.getItems().toString();
    }

    @Override
    public boolean exit() {
        return false;
    }
}
