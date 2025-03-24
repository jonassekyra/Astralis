package Player;

import World.Task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Player {
    private ArrayList<Item> items;
    private ArrayList<Task> allTasks = new ArrayList<>();
    private ArrayList<Task> completedTasks;
    private ArrayList<Task> accesibleTasks;
    private Module module;
    private boolean didSomething;

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Player() {
        this.items = new ArrayList<Item>();
        this.accesibleTasks = new ArrayList<>();
        this.completedTasks = new ArrayList<>();
        this.module = new Module();
    }

    public void completeTask(Task task) {
        completedTasks.add(task);
        accesibleTasks.remove(task);
    }

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
                        accesibleTasks.add(task);
                    }
                } else {
                    Task task = new Task(text, unlockedCondition, requiredLocation, requiredItemOrInteraction);
                    if (!parts[1].equals("start")) {
                        allTasks.add(task);
                    } else {
                        accesibleTasks.add(task);

                    }

                }

            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Task> getAccesibleTasks() {
        return accesibleTasks;
    }


    public ArrayList<Task> getAllTasks() {
        return allTasks;
    }

    public ArrayList<Task> getCompletedTasks() {
        return completedTasks;
    }

    public boolean isDidSomething() {
        return didSomething;
    }

    public boolean canUseItem(Item item, String currentLocation) {
        for (Task task : allTasks) {
            if (task.getUnlockedCondition().equals(item.getName())) {
                System.out.println("all tasks");
                return true;
            }

        }
        Iterator<Task> accTasks = accesibleTasks.iterator();
        while (accTasks.hasNext()) {
            Task task = accTasks.next();
            if (task.getRequiredItemOrInteraction() != null && task.getRequiredItemOrInteraction().equals(item.getName()) && task.getRequiredLocation().equals(currentLocation)) {
                return true;
            }
        }
        return false;

    }

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
                if (module.getLevel() >= 4) {
                    return true;
                }
                break;

            default:
                return true;

        }
        return false;
    }

    public void canItUpgradeModule(String item) {
        if (item.equals("palivo") || item.equals("vylepseni modulu")) {
            module.upgrade();
        }
    }

    public String checkTaskCompletion(String input, String currentLocation) {
        didSomething = false;
        Iterator<Task> completeIterator = accesibleTasks.iterator();
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

    public String checkForNewTasks(String input) {
        didSomething = false;
        Iterator<Task> taksIterator = allTasks.iterator();
        HashSet<String> tasks = new HashSet<>();
        while (taksIterator.hasNext()) {
            Task task = taksIterator.next();
            if (task.getUnlockedCondition().equals(input)) {
                tasks.add(task.getText());
                taksIterator.remove();
                accesibleTasks.add(task);
                didSomething = true;
            }
        }

        if (didSomething) {
            return "nove ukoly: " + accesibleTasks;
        } else {
            return "zadne nove ukoly";
        }
    }
}
