package Command;

import Player.Player;
import World.NPC;
import World.Task;
import World.WorldMap;

import java.util.Iterator;
import java.util.Scanner;




public class SpeakTo implements Command {
    public SpeakTo(WorldMap worldMap, Player player) {
        this.worldMap = worldMap;
        this.player = player;
    }

    private final WorldMap worldMap;
    private final Player player;
    boolean didSomething = false;
    @Override
    public String execute() {
        boolean didSomething = false;
        Scanner sc = new Scanner(System.in);
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            if (!worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS().isEmpty()){
                System.out.println("S kym by jsi chtel mluvit");
                String input = sc.nextLine().trim().toLowerCase();
                //Iterator for unlocking new tasks
                player.checkTaskCompletion(input,worldMap.getCurrentPosition());
                player.checkForNewTasks(input);





                for (NPC npc : worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS()) {
                    if (input.equals(npc.getName())) {
                        String dialog = npc.getDialogs().get(npc.getDialogCount());
                        if (didSomething) {
                            npc.setDialogCount(npc.getDialogCount() + 1);
                        }

                        return dialog;
                    }
                }
        }else {
             return "Neni tu nikdo s kym jsi mohl mluvit";
            }


        }return "Tuhle lokaci jste jeste neprozkoumali.";

    }

    @Override
    public boolean exit() {
        return false;
    }
}
