package Command;
import Player.Player;
import World.Task;
import World.WorldMap;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class GoTo implements Command {
    Scanner sc = new Scanner(System.in);
    private final WorldMap worldMap;
    private final Player player;

    public GoTo(WorldMap worldMap, Player player) {
        this.worldMap = worldMap;
        this.player = player;
    }

    @Override
    public String execute() {
        System.out.println("kam chcete jit?");
        String input = sc.nextLine();
        if (worldMap.locations.containsKey(input)) {
            if (Arrays.asList(worldMap.locations.get(worldMap.getCurrentPosition()).getPosibleLocations()).contains(input)) {
                worldMap.setCurrentPosition(input);
                //Iterator for unlocking new tasks
                Iterator<Task> taksIterator = player.getAllTasks().iterator();
                while (taksIterator.hasNext()) {
                    Task task = taksIterator.next();
                    if (task.getUnlockedCondition().equals(input)) {
                        player.getAccesibleTasks().add(task);
                        System.out.println("novy ukol: " + task.getText());
                    }
                }
                Iterator<Task> completeIterator = player.getAllTasks().iterator();
                while (completeIterator.hasNext()) {
                    Task task = completeIterator.next();
                    if (task.getRequiredItemOrInteraction().equals(input) && task.getRequiredLocation().equals(worldMap.getCurrentPosition())) {
                        completeIterator.remove();
                        player.compleateTask(task);
                        System.out.println("ukol splnen");
                    }
                }

        }else {
                System.out.println("do teto lokace se odsud nedostanete");
            }
    }else {
            System.out.println("lokace nexistuje");
        }

        return "jste v: " + worldMap.getCurrentPosition() ;
    }

    @Override
    public boolean exit() {
        return false;
    }
}