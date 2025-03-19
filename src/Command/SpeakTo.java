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
    @Override
    public String execute() {
        Scanner sc = new Scanner(System.in);
        if (worldMap.locations.get(worldMap.getCurrentPosition()).isExamined()){
            if (!worldMap.locations.get(worldMap.getCurrentPosition()).getNPCS().isEmpty()){
                System.out.println("S kym by jsi chtel mluvit");
                String input = sc.nextLine().trim().toLowerCase();
                //Iterator for unlocking new tasks
                Iterator<Task> taksIterator = player.getAllTasks().iterator();
                while (taksIterator.hasNext()) {
                    Task task = taksIterator.next();
                    if (task.getUnlockedCondition().equals(input)) {
                        player.getAccesibleTasks().add(task);
                        System.out.println("novy ukol: " + task.getText());
                    }
                }
                Iterator<Task> completeIterator = player.getAllTasks().iterator();
                while (completeIterator.hasNext()) {
                    Task task = completeIterator.next();
                    if (task.getRequiredItemOrInteraction().equals(input) && task.getRequiredLocation().equals(worldMap.getCurrentPosition())) {
                        completeIterator.remove();
                        player.compleateTask(task);
                        System.out.println("ukol splnen");
                    }
                }
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
