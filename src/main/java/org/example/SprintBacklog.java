package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SprintBacklog {
    private final List<Task> tasks = new ArrayList<>();
    private final int capacity;

    public SprintBacklog(int capacity) {
        this.capacity = capacity;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public int getCapacity() {
        return capacity;
    }

    public int calculateAvailableCapacity() {
        int plannedHolidays = 5;
        int companyHolidays = 2;
        int totalHolidays = plannedHolidays + companyHolidays;
        int teamVelocity = calculateTeamVelocity();
        int availableCapacity = capacity - totalHolidays - teamVelocity;
        return Math.max(availableCapacity, 0);
    }

    private int calculateTeamVelocity() {
        return 30;
    }

    public List<Task> getTasks() {
        return tasks;
    }
}
