package Command;
public class Help implements Command {
    @Override
    public String execute() {

        return """
                Prikazy:\s
                Help - Ukaze vsechny prikazy
                Go to - Posun do jine lokace
                Examine - Prohledani lokaci
                Grab - Seberani itemu
                Look around - Ukaze lokace, ktere vidite
                Use - Pouziti itemu
                Say - Postava neco rekne, napr v hadance
                Speak to - Promluveni s postavou""";
    }

    @Override
    public boolean exit() {
        return false;
    }
}
