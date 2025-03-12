package World;

import java.util.ArrayList;

public class NPC {
    private ArrayList<String> dialogs;
    private String name;

    public NPC(String name) {
        this.name = name;
    }

    public boolean loadDialogs(){
        return true;
    }
    public String talk(){
        return null;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                '}';
    }
}
