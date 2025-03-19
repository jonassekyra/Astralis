package Command;

import Player.Item;
import Player.Player;
import World.Task;
import World.WorldMap;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Grab implements Command {
    private WorldMap worldMap;
    private Player p;
    Scanner sc = new Scanner(System.in);

    public Grab(WorldMap worldMap, Player p) {
        this.worldMap = worldMap;
        this.p = p;
    }

    @Override
    public String execute() {
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()) {
            System.out.println("Jaky item chcete vzit?");
            String input = sc.nextLine().trim().toLowerCase();
            String location = worldMap.getCurrentPosition();

            Iterator<Item> it = worldMap.locations.get(worldMap.getCurrentPosition()).getItems().iterator();
            while (it.hasNext()) {
                Item item = it.next();
                if (item.getName().equals(input)) {
                    p.addItem(item);
                    it.remove();
                    System.out.println("Sebral jsi: " + item.getName());
                    Iterator<Task> taskIterator = p.getAllTasks().iterator();
                    while (taskIterator.hasNext()) {
                        Task task = taskIterator.next();
                        if (task.getUnlockedCondition().equals(input)) {
                            p.getAccesibleTasks().add(task);
                            System.out.println("novy ukol: " + task.getText());
                        }

                        if (task.getRequiredItemOrInteraction().equals(input) && task.getRequiredLocation().equals(location)) {
                            taskIterator.remove();
                            p.compleateTask(task);
                            System.out.println("ukol splnen");
                        }
                    }
                    return "ukoly aktualizovany";
                }

            }
        }
        return "item neexistuje";
    }
            @Override
            public boolean exit () {
                return false;
            }
        }