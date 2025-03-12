package Player;
import World.Task;
import World.WorldMap;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Player {
    private ArrayList<Item> items;
    private ArrayList<Task> allTasks;
    private ArrayList<Task> completedTasks;
    private ArrayList<Task> accesibleTasks;
    private WorldMap worldMap;

    public void addItem(Item item) {
        items.add(item);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Player() {
        this. items = new ArrayList<Item>();
        this.accesibleTasks = new ArrayList<>();
    }

    public void compleateTask() {}
    public void addAccesibleTask() {

    }
    public void loadTasks() {
        allTasks = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("tasks.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                Task task = new Task(parts[0],parts[1]);
                if (!parts[1].equals("start")) {
                    allTasks.add(task);

                }else{
                    accesibleTasks.add(task);
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
}
