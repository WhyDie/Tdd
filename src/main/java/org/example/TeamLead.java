package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class TeamLead {
    private String name;
    private String lastName;
    private double salary;
    private String position;
    private Status status;
    private PriorityQueue<Task> tasks = new PriorityQueue<>((t1, t2) -> t2.getPriority().compareTo(t1.getPriority()));

    public TeamLead(String name, String lastName, double salary) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.position = "team lead";
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    public String getPosition() {
        return position;
    }

    public void moveTasksToSprintBacklog(ProductBacklog productBacklog, SprintBacklog sprintBacklog) {
        PriorityQueue<Task> productBacklogTasks = productBacklog.getTasks();

        while (!productBacklogTasks.isEmpty()) {
            Task task = productBacklogTasks.poll();
            sprintBacklog.addTask(task);
        }
    }

    public void inspectSprintBacklog(SprintBacklog sprintBacklog) {
        List<Task> sprintBacklogTasks = sprintBacklog.getTasks();
        List<Task> tasksToRemove = new ArrayList<>();

        for (Task task : sprintBacklogTasks) {
            if (task.getStatus() == Status.DONE) {
                tasksToRemove.add(task);
            }
        }

        sprintBacklogTasks.removeAll(tasksToRemove);
    }

    public void markTaskAsDone(Task task) {
        this.status = Status.DONE;
    }
}
