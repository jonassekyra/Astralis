import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WorldMap{
    HashMap<String,ArrayList<String>> location = new HashMap<>();
    public boolean loadMap(){
        try (BufferedReader br = new BufferedReader(new FileReader("worldMap.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] lines = line.split("-");
                location.put(lines[0],new ArrayList<>());

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

}


