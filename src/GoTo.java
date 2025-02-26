import java.util.Arrays;
import java.util.Scanner;

public class GoTo implements Command {
    Scanner sc = new Scanner(System.in);
    WorldMap worldMap = new WorldMap();
    private String currentLocation;


    @Override
    public String execute() {
        currentLocation = worldMap.getCurrentPosition();
        System.out.println("kam chcete jit?");
        String input = sc.nextLine();
        if (worldMap.locations.containsKey(input)) {
            if (Arrays.asList(worldMap.locations.get(currentLocation).getPosibleLocations()).contains(input)) {
                worldMap.setCurrentPosition(input);

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