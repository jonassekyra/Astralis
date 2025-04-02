package Command;
import Player.Player;
import Player.Item;
import World.WorldMap;
import java.util.Iterator;
import java.util.Scanner;

/**
 * used for using an item
 */
public class Use implements Command {
    private final Player player;
    private final WorldMap worldMap;
    Scanner sc = new Scanner(System.in);

    /**
     * Iterates trough players items and checks for match with input.
     * Checks if the player can use certain item at that time and if it can upgrade module.
     * checks for new or competed tasks.
     * @return used or not
     */
    @Override
    public String execute() {
        if (player.getItems().isEmpty()) {
            return "Nemate zadny item na pouziti";
        }
        System.out.println("Jaky item chcete pouzit?");
        String input = sc.nextLine().toLowerCase().trim();

        Iterator<Item> it = player.getItems().iterator();

        while (it.hasNext()) {
            Item item = it.next();

            if (item.name().equalsIgnoreCase(input)) {


                if (!player.canUseItem(item, worldMap.getCurrentPosition())) {

                    return "tento item zde nelze pouzit";

                }
                player.canItUpgradeModule(input);

                if (player.getAllTasks() != null|| player.getAccessibleTasks() != null) {
                    it.remove();
                    System.out.println(player.checkForNewTasks(input));
                    System.out.println(player.checkTaskCompletion(input, worldMap.getCurrentPosition()));



                }
                if (player.isDidCompleteTask()) {
                    return "pouzito";
                } else {
                    return "tento item zde nelze pouzit";
                }
            }
        }
        return "tento item nelze pouzit";


    }

    @Override
    public boolean exit() {
        return false;
    }

    public Use(Player player, WorldMap worldMap) {
        this.player = player;
        this.worldMap = worldMap;
    }
}
