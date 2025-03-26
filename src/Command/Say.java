package Command;
import World.WorldMap;
import java.util.Scanner;

/**
 * Used to say something in game
 */
public class Say implements Command {
    Scanner sc = new Scanner(System.in);
    private final WorldMap worldMap;

    /**
     * checks if the input equals to strom.
     * @return right or wrong
     */
    @Override
    public String execute() {
        String temp = worldMap.getCurrentPosition();
        if(temp.equals("zkamenely les")) {
            System.out.println("Co chcete rict?");
            String input = sc.nextLine().trim().toLowerCase();
            if(input.equals("strom")) {
                return "spravne";
            }else {
                return "nope";
            }

        }return "Ted dava opravdu velky smysl neco rikat, ze jo (.-.) ";

    }

    @Override
    public boolean exit() {
        return false;
    }

    public Say(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
