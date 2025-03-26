package Command;
import Player.Player;

/**
 * shows tasks
 */
public class showTasks implements Command {
    private final Player player;

    /**
     *
     * @return accessible tasks
     */
    @Override
    public String execute() {
        return "vase ukoly: " + player.getAccessibleTasks();
    }

    @Override
    public boolean exit() {
        return false;
    }

    public showTasks(Player player) {
        this.player = player;
    }
}
