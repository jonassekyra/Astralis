package Command;

import Player.Player;

public class showTasks implements Command {
    private Player player;

    @Override
    public String execute() {
        return "vase ukoly: " + player.getAccesibleTasks();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public showTasks(Player player) {
        this.player = player;
    }
}
