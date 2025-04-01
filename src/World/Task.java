package World;
import Player.Item;

public class Task {
    private String text;
    private String unlockedCondition;
    private String requiredLocation;
    private final String requiredItemOrInteraction;
    private Item reward;


    /**
     * Constructor to create tasks with reward.
     * @param text Task description
     * @param unlockedCondition condition that unlocks the task
     * @param requiredLocation location that is required for completing the task.
     * @param requiredItemOrInteraction Item or interaction that is required for completing the task.
     * @param reward that is given to the player after completing the task.
     */
    public Task(String text, String unlockedCondition, String requiredLocation, String requiredItemOrInteraction,Item reward) {
        this.text = text;
        this.unlockedCondition = unlockedCondition;
        this.requiredLocation = requiredLocation;
        this.requiredItemOrInteraction = requiredItemOrInteraction;
        this.reward = reward;
    }

    /**
     * Constructor to create tasks without reward.
     * @param text Task description
     * @param unlockedCondition condition that unlocks the task
     * @param requiredLocation location that is required for completing the task.
     * @param requiredItemOrInteraction Item or interaction that is required for completing the task.
     */
    public Task(String text, String unlockedCondition, String requiredLocation, String requiredItemOrInteraction) {
        this.text = text;
        this.unlockedCondition = unlockedCondition;
        this.requiredLocation = requiredLocation;
        this.requiredItemOrInteraction = requiredItemOrInteraction;
    }

    public Item getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return "Task: " + text;
    }


    public String getText() {
        return text;
    }

    public String getUnlockedCondition() {
        return unlockedCondition;
    }

    public String getRequiredLocation() {
        return requiredLocation;
    }


    public String getRequiredItemOrInteraction() {
        return requiredItemOrInteraction;
    }


}
