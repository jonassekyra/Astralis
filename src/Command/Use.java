package Command;

import Player.Player;
import Player.Item;
import World.Task;
import World.WorldMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Use implements Command {
    private final Player player;
    private final WorldMap worldMap;
    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        if (player.getItems().isEmpty()) {
            return "Nemate zadny item na pouziti";
        }
        System.out.println("Jaky item chcete pouzit?");
        String input = sc.nextLine().toLowerCase().trim();

        Iterator<Item> it = player.getItems().iterator();
        boolean itemUsed = false;
        Item itemToRemove = null;

         ArrayList<Task> taskToAdd = new ArrayList<Task>();
         ArrayList<Task> tasksToRemove = new ArrayList<>();

        while (it.hasNext()) {
            Item item = it.next();

            if (item.getName().equalsIgnoreCase(input)) {
                if (!player.canUseItem(item, worldMap.getCurrentPosition())) {
                    return "tento item zde nelze pouzit";
                }
                int count = 0;
                if (player.getAllTasks() != null) {



                    for (Task task : player.getAllTasks()) {

                        if (task.getUnlockedCondition() != null && task.getUnlockedCondition().equals(item.getName()) && player.getAccesibleTasks() != null && !player.getAccesibleTasks().contains(task)) {
                            taskToAdd.add(task);
                            tasksToRemove.add(task);
                            count++;
                            System.out.println("novy ukol: " + task.getText());


                        }
                        // task complete
                        if (task.getRequiredLocation() != null && task.getRequiredLocation().equals(worldMap.getCurrentPosition()) && task.getRequiredItemOrInteraction() != null && task.getRequiredItemOrInteraction().equals(item.getName())) {
                            player.compleateTask(task);
                            count++;
                            System.out.println("ukol splnen");
                        }

                    }

                }
                if (count > 0) {
                    itemUsed = true;
                    itemToRemove = item;
                    return "pouzito";
                } else {
                    return "tento item zde nelze pouzit";
                }
            }
            player.getAccesibleTasks().addAll(taskToAdd);
            player.getAllTasks().removeAll(tasksToRemove);

            if (itemUsed && itemToRemove != null) {
                it.remove();
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
