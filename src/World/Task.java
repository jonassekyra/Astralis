package World;

import Player.Item;

import java.util.Iterator;

public class Task {
    private String text;
    private boolean completed = false;
    private String unlockedCondition;
    private String requiredLocation;
    private final String requiredItemOrInteraction;
    private Item reward;



    public Task(String text, String unlockedCondition, String requiredLocation, String requiredItemOrInteraction,Item reward) {
        this.text = text;
        this.unlockedCondition = unlockedCondition;
        this.requiredLocation = requiredLocation;
        this.requiredItemOrInteraction = requiredItemOrInteraction;
        this.reward = reward;
    }

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

    public void setText(String text) {
        this.text = text;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public String getUnlockedCondition() {
        return unlockedCondition;
    }

    public void setUnlockedCondition(String unlockedCondition) {
        this.unlockedCondition = unlockedCondition;
    }

    public String getRequiredLocation() {
        return requiredLocation;
    }

    public void setRequiredLocation(String requiredLocation) {
        this.requiredLocation = requiredLocation;
    }

    public String getRequiredItemOrInteraction() {
        return requiredItemOrInteraction;
    }

    public void setRequiredItem(String requiredItem) {
        this.requiredLocation = requiredItem;
    }



}
