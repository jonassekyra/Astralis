package Command;

import World.WorldMap;

import java.util.Scanner;

public class Say implements Command {
    Scanner sc = new Scanner(System.in);
    private final WorldMap worldMap;
    @Override
    public String execute() {
        String temp = worldMap.getCurrentPosition();
        if(temp.equals("zkamenely les")) {
            System.out.println("Co chcete rict?");
            String input = sc.nextLine().trim().toLowerCase();
            if(input.equals("strom")) {
                return "spravne";
            }

        }return "Ted dava opravdu velky smysl neco rikat, ze jo .-. ";

    }

    @Override
    public boolean exit() {
        return false;
    }

    public Say(WorldMap worldMap) {
        this.worldMap = worldMap;
    }
}
