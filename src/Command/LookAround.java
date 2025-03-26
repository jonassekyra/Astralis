package Command;
import World.WorldMap;
import java.util.Arrays;
/**
 * shows locations around you
 */
public class LookAround implements Command {
    private final WorldMap world;

    /**
     *
     * @return List of locations around you
     */
    @Override
    public String execute() {
        return "you can see: " + Arrays.toString(world.locations.get(world.getCurrentPosition()).getPosibleLocations());
    }

    public LookAround(WorldMap world) {
        this.world = world;
    }

    @Override
    public boolean exit() {
        return false;
    }
}
