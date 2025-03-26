package Command;
import Player.Player;
import World.WorldMap;
import java.util.Arrays;
import java.util.Scanner;

/**
 *Travel across locations
 */
public class GoTo implements Command {
    Scanner sc = new Scanner(System.in);
    private final WorldMap worldMap;
    private final Player player;

    public GoTo(WorldMap worldMap, Player player) {
        this.worldMap = worldMap;
        this.player = player;
    }

    /**
     * Checks the players input with hashMap keys, then if you can travel to it and if there are any new or completed tasks.
     * @return players current location
     */
    @Override
    public String execute() {
        System.out.println("kam chcete jit?");
        String input = sc.nextLine().toLowerCase().trim();
        if (worldMap.locations.containsKey(input)) {
            if (Arrays.asList(worldMap.locations.get(worldMap.getCurrentPosition()).getPosibleLocations()).contains(input)) {
                if (player.canTravelTo(input)){
                    worldMap.setCurrentPosition(input);
                    System.out.println(player.checkForNewTasks(input));
                    System.out.println(player.checkTaskCompletion(input,worldMap.getCurrentPosition()));
                }else {
                    return "Sem jeste nemuzes";
                }


        }else {
                System.out.println("do teto lokace se odsud nedostanete");
            }
    }else {
            System.out.println("lokace nexistuje");
        }

        return "jste v: " + worldMap.getCurrentPosition() ;
    }

    public void setSc(Scanner sc) {
        this.sc = sc;
    }

    @Override
    public boolean exit() {
        return false;
    }
}