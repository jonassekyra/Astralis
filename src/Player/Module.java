package Player;

public class Module {
    private int level = 0;

    public void upgrade() {
        level++;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
