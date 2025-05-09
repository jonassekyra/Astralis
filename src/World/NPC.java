package World;

import java.util.ArrayList;
import java.util.Objects;

public class NPC {
    private final ArrayList<String> dialogs;
    private final String name;
    private int dialogCount = -1;


    public NPC(String name, ArrayList<String> dialogs) {
        this.name = name;
        this.dialogs = dialogs;
    }

    @Override
    public String toString() {
        return "NPC{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NPC npc = (NPC) o;
        return Objects.equals(name, npc.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getDialogs() {
        return dialogs;
    }

    public int getDialogCount() {
        return dialogCount;
    }

    public void setDialogCount(int dialogCount) {
        this.dialogCount = dialogCount;
    }
}
