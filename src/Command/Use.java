package Command;
import Player.Player;
import Player.Item;
import java.util.Scanner;

public class Use implements Command {
    private final Player player;
    Scanner sc = new Scanner(System.in);

    @Override
    public String execute() {
        if (!player.getItems().isEmpty()) {
            System.out.println("Jaky item chcete pouzit?");
            String input = sc.nextLine().toLowerCase().trim();
            for (Item item : player.getItems()) {
                if(item.getName().equals(input)) {
                    player.getItems().remove(item);
                }
            }
        }else {
            return "Nemate zadny item na pouziti";
        }
        return "pouzito uspesne";
    }

    @Override
    public boolean exit() {
        return false;
    }

    public Use(Player player) {
        this.player = player;
    }
}
