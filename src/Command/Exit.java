package Command;
/**
 * Stops program
 */
public class Exit implements Command {
    @Override
    public String execute() {
        return "hra byla ukoncena";
    }
    @Override
    public boolean exit() {
        return true;
    }
}
