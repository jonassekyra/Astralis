package Player;

import World.Task;
import World.WorldMap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
Player player = new Player();
Task t1 = new Task("Pridej palivo do modulu.","palivo","modul mesic","palivo");
Task t2 = new Task("Vylepsi modul.","vedec","modul mars","vylepseni modulu");
HashSet<String> tasks = new HashSet<>();
    @BeforeEach
    void setUp() {
        tasks.add("Pridej palivo do modulu.");
        player.getAllTasks().add(t2);
        player.getAccessibleTasks().add(t1);
        player.getModule().setLevel(1);
    }

    @Test
    void canUseItem() {
       boolean result = player.canUseItem(new Item("palivo"),"modul mesic");
       assertTrue(result);
    }

    @Test
    void canTravelTo() {
        boolean result = player.canTravelTo("zakladna");
        assertTrue(result);

    }
    @Test
    void IcanTravelTo() {
        boolean result = player.canTravelTo("modul mars");
        assertTrue(result);

    }

    @Test
    void checkTaskCompletion() {
        String result = player.checkTaskCompletion("palivo","modul mesic");
        assertEquals("splnene ukoly: [Pridej palivo do modulu.]", result);
    }

    @Test
    void checkForNewTasks() {
        String result = player.checkForNewTasks("vedec");
        assertEquals("nove ukoly: [Task: Pridej palivo do modulu., Task: Vylepsi modul.]", result);
    }
}