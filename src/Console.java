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


}
