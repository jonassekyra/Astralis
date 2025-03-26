package Command;
import Player.Item;
import Player.Player;
import World.Location;
import World.NPC;
import World.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class GoToTest {
    WorldMap worldMap = new WorldMap();
    Player player = new Player();
    Location location;
    GoTo goTo = new GoTo(worldMap, player);
    @BeforeEach
    void setUp() {
        worldMap.setCurrentPosition("modul mesic");
        String[] possibleLoc = {"zakladna"};
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("modul mesic"));
        HashSet<NPC> npcs = new HashSet<>();
        ArrayList<String> dialog = new ArrayList<>();
        dialog.add("programovani je skvele, tesim se na dalsi projekt:)");
        npcs.add(new NPC("jarda",dialog));
        location = new Location("zakladna",possibleLoc,items,npcs);
        worldMap.locations.put("modul mesic", location);
    }

    @Test
    void execute() {
        String input = "zakladna\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);
        goTo.setSc(scanner);
        String result = goTo.execute();
        assertEquals("jste v: zakladna", result);
    }
}