package World;

import Player.Item;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class WorldMap {
    private final String startPosition = "modul mesic";
    private String currentPosition = startPosition;
    public HashMap<String, Location> locations = new HashMap<>();


    public boolean loadMap() {
        try (BufferedReader br = new BufferedReader(new FileReader("worldMap.txt"))) {
            String line;
            int temp = 0;
            while ((line = br.readLine()) != null) {
                temp++;
                String[] lines = line.split("-");
                ArrayList<Item> items = loadItems(temp);
                HashSet<NPC> npcs = loadNPC(temp);
                Location location = new Location(lines[0], Arrays.copyOfRange(lines, 1, lines.length), items, npcs);
                locations.put(lines[0], location);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ArrayList<Item> loadItems(int line) {
        ArrayList<Item> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Items.txt"))) {
            String line1;
            int currentLine = 0;
            while ((line1 = br.readLine()) != null) {
                currentLine++;
                if (currentLine == line) {
                    String[] lines = line1.split("-");
                    for (int i = 0; i < lines.length; i++) {
                        Item item = new Item(lines[i]);
                        items.add(item);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return items;
    }

    public HashSet<NPC> loadNPC(int line) {
        HashSet<NPC> npcs = new HashSet<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Npcs.txt"))){
            String line1;
            int currentLine = 0;
            while ((line1 = br.readLine()) != null) {
                currentLine++;
                if (currentLine == line) {
                    String[] lines = line1.split("-");
                    String[] dialogs = Arrays.copyOfRange(lines,1,lines.length);
                    ArrayList<String> dialogsList = new ArrayList<>(Arrays.asList(dialogs));
                        NPC npc = new NPC(lines[0],dialogsList);
                        npcs.add(npc);
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return npcs;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public WorldMap() {
        loadMap();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldMap worldMap = (WorldMap) o;
        return Objects.equals(currentPosition, worldMap.currentPosition);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(currentPosition);
    }
}


