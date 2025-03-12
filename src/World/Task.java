package World;

public class Task {
    private String text;
    private boolean completed = false ;
    private String unlockedCondition;

    public Task(String text, String unlockedCondition) {
        this.text = text;
        this.unlockedCondition = unlockedCondition;
    }

    @Override
    public String toString() {
        return "Task: " + text;
    }
}
