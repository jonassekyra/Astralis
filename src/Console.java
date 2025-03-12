import Command.*;
import Player.Player;
import World.WorldMap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<String, Command>();
    WorldMap world = new WorldMap();
    Player p = new Player();

    public void initialization(){
        p.loadTasks();
        commands.put("go to", new GoTo(world));
        commands.put("exit", new Exit());
        commands.put("examine", new Examine(world));
        commands.put("grab", new Grab(world,p));
        commands.put("look around", new LookAround(world));
        commands.put("say", new Say(world));
        commands.put("use", new Use(p));
        commands.put("speak to", new SpeakTo(world));
        commands.put("show tasks", new showTasks(p));
    }

    Scanner sc = new Scanner(System.in);

    public void doCommand(){
        System.out.println("-->>");
        String input = sc.nextLine().trim().toLowerCase();
        if (commands.containsKey(input)){
            System.out.println("-->> " + commands.get(input).execute());
            exit = commands.get(input).exit();

        }else {
            System.out.println("nedefinovany prikaz");
        }

    }

    public void start(){
        initialization();
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
