package Player;
import World.Task;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * player
 */
public class Player {
    private ArrayList<Item> items;
    private ArrayList<Task> allTasks;
    private ArrayList<Task> completedTasks;
    private ArrayList<Task> accessibleTasks;
    private final Module module;
    private boolean didSomething;

    /**
     * adds item to inventory
     * @param item item that is added
     */
    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Module getModule() {
        return module;
    }

    public Player() {
        this.items = new ArrayList<Item>();
        this.accessibleTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.allTasks = new ArrayList<>();
        this.module = new Module();
    }

    /**
     * Adds task to completed tasks.
     * Removes task from accessible tasks.
     * @param task that is being moved
     */
    public void completeTask(Task task) {
        completedTasks.add(task);
        accessibleTasks.remove(task);
    }

    /**
     *loads tasks from file.
     * If the length of the line is 5 it also adds reward
     */
    public void loadTasks() {
        allTasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String text = parts[0];
                String unlockedCondition = parts[1];
                String requiredLocation = parts[2];
                String requiredItemOrInteraction = parts[3];

                if (parts.length >= 5 && !parts[4].isEmpty()) {
                    Item reward = new Item(parts[4]);
                    Task task = new Task(text, unlockedCondition, requiredLocation, requiredItemOrInteraction, reward);
                    if (!parts[1].equals("start")) {
                        allTasks.add(task);
                    } else {
                        accessibleTasks.add(task);
                    }
                } else {
                    Task task = new Task(text, unlockedCondition, requiredLocation, requiredItemOrInteraction);
                    if (!parts[1].equals("start")) {
                        allTasks.add(task);
                    } else {
                        accessibleTasks.add(task);

                    }

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Task> getAccessibleTasks() {
        return accessibleTasks;
    }


    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }


    public boolean isDidSomething() {
        return didSomething;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    /**
     *Check if the item can either start new task or complete one.
     * @param item the player wants to use.
     * @param currentLocation of the player.
     * @return True if item can update tasks.
     */
    public boolean canUseItem(Item item, String currentLocation) {
        for (Task task : allTasks) {
            if (task.getUnlockedCondition().equals(item.name())) {
                return true;
            }

        }
        for (Task task : accessibleTasks) {
            if (task.getRequiredItemOrInteraction() != null && task.getRequiredItemOrInteraction().equals(item.name())
                    && task.getRequiredLocation().equals(currentLocation)) {
                return true;
            }
        }
        return false;

    }

    /**
     * Uses switch to check if the player has a required level of module so he can travel to a new planet.
     * Default is true so if the input isn't a planet the player can go there without problems.
     * @param location the player wants to go to.
     * @return true if the level of module is high enough.
     */
    public boolean canTravelTo(String location) {
        switch (location) {
            case "modul mars":
                if (module.getLevel() >= 1) {
                    return true;
                }
                break;
            case "modul europa", "modul titan":
                if (module.getLevel() >= 2) {
                    return true;
                }
                break;
            case "modul pluto":
                if (module.getLevel() >= 3) {
                    return true;
                }
                break;

            default:
                return true;

        }
        return false;
    }

    /**
     * Check if the item the player wants to use can upgrade module, If so it upgrades module.
     * @param item the player wants to use.
     */
    public void canItUpgradeModule(String item) {
        if (item.equals("palivo") || item.equals("vylepseni modulu")) {
            module.upgrade();
        }
    }

    /**
     * Checks for completed task by Iterating trough accessible task and checking if the required location and itemOrInteraction matach the
     * current location and input
     * @param input from player(item,name of npc,location)
     * @param currentLocation of the player
     * @return list of completed tasks
     */
    public String checkTaskCompletion(String input, String currentLocation) {
        didSomething = false;
        Iterator<Task> completeIterator = accessibleTasks.iterator();
        HashSet<String> tasks = new HashSet<>();
        while (completeIterator.hasNext()) {

            Task task = completeIterator.next();

            if (task.getRequiredItemOrInteraction() != null && task.getRequiredItemOrInteraction().equals(input) && task.getRequiredLocation().equals(currentLocation)) {
                tasks.add(task.getText());

                completeIterator.remove();
                completeTask(task);


                didSomething = true;

                if (task.getReward() != null) {
                    items.add(task.getReward());

                }
            }

        }

        if (didSomething) {
            return "splnene ukoly: " + tasks;

        } else {
            return "zadne splnene ukoly";

        }

    }

    /**
     * Checks for new tasks by Iterating trough allTasks and checking if the user input matches the unlock condition.
     * @param input from player(item,name of npc,location)
     * @return Array of new tasks.
     */
    public String checkForNewTasks(String input) {
        didSomething = false;
        Iterator<Task> taksIterator = allTasks.iterator();
        HashSet<String> tasks = new HashSet<>();
        while (taksIterator.hasNext()) {
            Task task = taksIterator.next();
            if (task.getUnlockedCondition().equals(input)) {
                tasks.add(task.getText());
                taksIterator.remove();
                accessibleTasks.add(task);
                didSomething = true;
            }
        }

        if (didSomething) {
            return "nove ukoly: " + accessibleTasks;
        } else {
            return "zadne nove ukoly";
        }
    }
}
