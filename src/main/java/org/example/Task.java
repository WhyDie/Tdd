package org.example;

import java.util.Random;

public class Task {
    private static int nextId = 1;

    private int id;
    private String name;
    private Status status;
    private int storyPoints;
    private Priority priority;

    public Task(String name, int storyPoints) {
        this.id = nextId++;
        this.name = name + id;
        this.status = Status.TO_DO;
        this.storyPoints = storyPoints;
        this.priority = generateRandomPriority();
    }

    private Priority generateRandomPriority() {
        Priority[] priorities = Priority.values();
        return priorities[new Random().nextInt(priorities.length)];
    }

    public static int getNextId() {
        return nextId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public int getStoryPoints() {
        return storyPoints;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void markAsDone() {
        this.status = Status.DONE;
    }
}
