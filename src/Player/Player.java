package Player;

import World.Task;
import World.WorldMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Player {
    private ArrayList<Item> items;
    private ArrayList<Task> allTasks;
    private ArrayList<Task> completedTasks;
    private ArrayList<Task> accesibleTasks;
    private Module module;

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

    public void compleateTask(Task task) {
        completedTasks.add(task);
        accesibleTasks.remove(task);
    }

    public void loadTasks() {
        allTasks = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0], parts[1], parts[2], parts[3]);
                if (!parts[1].equals("start")) {
                    allTasks.add(task);

                } else {
                    accesibleTasks.add(task);
                    allTasks.add(task);
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

    public boolean canUseItem(Item item, String currentLocation) {
        for (Task task : allTasks) {
            if ((task.getRequiredLocation() != null && task.getRequiredLocation().equals(currentLocation) && task.getRequiredItemOrInteraction() != null && task.getRequiredItemOrInteraction().equals(item.getName()))) {
                return true;
            }
            if (task.getUnlockedCondition() != null && task.getUnlockedCondition().equals(item.getName()) && getAccesibleTasks() != null && !getAccesibleTasks().contains(task)) {
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
            case "modul europa":
                if (module.getLevel() >= 2) {
                    return true;
                }
                break;
            case "modul titan":
                if (module.getLevel() >= 3) {
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


}
