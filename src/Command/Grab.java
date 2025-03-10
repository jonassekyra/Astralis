package Command;

import World.WorldMap;

public class Grab implements Command {
    private WorldMap worldMap;

    public Grab(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    @Override
    public String execute() {
        return "";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
