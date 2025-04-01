package Command;
import Player.Item;
import Player.Player;
import World.WorldMap;
import java.util.Iterator;
import java.util.Scanner;
/**
 * Used for getting items into inventory
 */
public class Grab implements Command {
    private final WorldMap worldMap;
    private final Player p;
    Scanner sc = new Scanner(System.in);

    public Grab(WorldMap worldMap, Player p) {
        this.worldMap = worldMap;
        this.p = p;
    }

    /**
     * Iterates trough items from location, if it's same as input it checks for new or completed tasks.
     * @return item that was picked up.
     */
    @Override
    public String execute() {
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()) {
            System.out.println("Jaky item chcete vzit?");
            String input = sc.nextLine().trim().toLowerCase();
            String location = worldMap.getCurrentPosition();

            Iterator<Item> it = worldMap.locations.get(worldMap.getCurrentPosition()).getItems().iterator();
            while (it.hasNext()) {
                Item item = it.next();
                if (item.name().equals(input)) {
                    p.addItem(item);
                    System.out.println(p.checkTaskCompletion(input, location));
                    System.out.println(p.checkForNewTasks(input));


                    it.remove();
                    if (p.isDidSomething()){
                        return "ukoly aktualizovany, " + "sebral jsi: " + item.name();
                    }else {
                        return "sebral jsi" + item.name();
                    }
                }else{
                    return "neplatny item";
                }
            }
        }else {
            return "Nejdrive prohledejte lokaci.";
        }
        return p.getItems().toString();

    }
            @Override
            public boolean exit () {
                return false;
            }
        }