package Player;

/**
 * module the player uses to travel between planets.
 */
public class Module {
    private int level = 0;

    /**
     * adds 1 level
     */
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
