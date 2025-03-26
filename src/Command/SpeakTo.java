package Command;
import Player.Player;
import World.NPC;
import Player.Item;
import World.WorldMap;

import javax.imageio.ImageTranscoder;
import java.util.Scanner;




public class SpeakTo implements Command {
    public SpeakTo(WorldMap worldMap, Player player) {
        this.worldMap = worldMap;
        this.player = player;
    }

    private final WorldMap worldMap;
    private final Player player;
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            if (!worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS().isEmpty()){
                System.out.println("S kym by jsi chtel mluvit");
                String input = sc.nextLine().trim().toLowerCase();
                //Iterator for unlocking new tasks
                System.out.println(player.checkTaskCompletion(input,worldMap.getCurrentPosition()));
                //System.out.println(player.checkTasksFromInventory());
                System.out.println(player.checkForNewTasks(input));


                for (NPC npc : worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS()) {
                    if (input.equals("tajemna bytost")){
                        npc.setDialogCount(npc.getDialogCount() + 1);
                        return npc.getDialogs().get(npc.getDialogCount());
                    } else if (input.equals(npc.getName())) {
                        if (player.isDidSomething()) {
                            npc.setDialogCount(npc.getDialogCount() + 1);
                        }
                        return npc.getDialogs().get(npc.getDialogCount());
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
