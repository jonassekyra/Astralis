package Command;
import World.WorldMap;

public class Examine implements Command{
    private final WorldMap worldMap;

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
}
