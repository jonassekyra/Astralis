package Command;

import World.NPC;
import World.WorldMap;

import java.util.Scanner;




public class SpeakTo implements Command {
    public SpeakTo(WorldMap worldMap) {
        this.worldMap = worldMap;
    }

    private final WorldMap worldMap;
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            if (!worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS().isEmpty()){
                System.out.println("S kym by jsi chtel mluvit");
                String input = sc.nextLine().trim().toLowerCase();
                for (NPC npc : worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS()) {
                    if (input.equals(npc.getName())) {
                        String dialog = npc.getDialogs().get(npc.getDialogCount());
                        npc.setDialogCount(npc.getDialogCount() + 1);
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
