import Command.*;

import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private boolean exit = false;
    private HashMap<String, Command> commands = new HashMap<String, Command>();

    public void inicialization(){
        commands.put("go to", new GoTo());
    }

    Scanner sc = new Scanner(System.in);

    public void doCommand(){
        System.out.println("-->>");
        String input = sc.nextLine().trim().toLowerCase();
        if (commands.containsKey(input)){
            System.out.println("-->> " + commands.get(input).execute());

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
