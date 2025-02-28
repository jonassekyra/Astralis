package World;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;


public class WorldMap{
    private final String startPosition = "modul mesic";
    private String currentPosition = startPosition;
    public HashMap<String, Location> locations = new HashMap<>();
    public boolean loadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("worldMap.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");
                Location location = new Location(lines[0],Arrays.copyOfRange(lines, 1, lines.length));
                locations.put(lines[0],location);

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
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
}


