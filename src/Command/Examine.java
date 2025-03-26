package Command;
import World.WorldMap;
//Used to show what items or NPCs are in a location
public class Examine implements Command{
    private final WorldMap worldMap;

    public Examine(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    /**
     * Checks if the location is examined if so, it shows items and npcs.
     * @return list of items and npcs
     */
    @Override
    public String execute() {
        if (!worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            worldMap.locations.get(worldMap.getCurrentPosition()).setExamined(true);
            return "you found: " + worldMap.locations.get(worldMap.getCurrentPosition()).getItems() + worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS();

        }else {
            return "allready examined";
        }

    }
    @Override
    public boolean exit() {
        return false;
    }
}
