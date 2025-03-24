package Command;
import Player.Player;
import World.WorldMap;
import java.util.Arrays;
import java.util.Scanner;

public class GoTo implements Command {
    Scanner sc = new Scanner(System.in);
    private final WorldMap worldMap;
    private final Player player;

    public GoTo(WorldMap worldMap, Player player) {
        this.worldMap = worldMap;
        this.player = player;
    }

    @Override
    public String execute() {
        System.out.println("kam chcete jit?");
        String input = sc.nextLine();
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

    @Override
    public boolean exit() {
        return false;
    }
}