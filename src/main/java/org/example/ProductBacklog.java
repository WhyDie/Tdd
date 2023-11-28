package org.example;

import java.util.PriorityQueue;

public class ProductBacklog {
    private PriorityQueue<Task> tasks = new PriorityQueue<>((t1, t2) -> t2.getPriority().compareTo(t1.getPriority()));

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(Task task) {
        tasks.remove(task);
    }

    public void moveTask(Task task, Priority newPriority) {
        tasks.remove(task);
        tasks.add(task);
    }

    public PriorityQueue<Task> getTasks() {
        return tasks;
    }
}
