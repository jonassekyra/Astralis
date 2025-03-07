import Command.*;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public void inicialization(){
        commands.put("go to", new GoTo());
        commands.put("exit", new Exit());
        commands.put("examine", new Examine());
        commands.put("grab", new Grab());
        commands.put("look around", new LookAround());
        commands.put("say", new Say());
        commands.put("use", new Use());
        commands.put("speak to", new SpeakTo());
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
        inicialization();
        try{
            do{
                doCommand();
            }while(!exit);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


}
