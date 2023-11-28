package org.example;

public class Developer {
    private String name;
    private String lastName;
    private double salary;
    private String position;
    private int doneTaskCount;
    private int score;
    private SprintBacklog assignedSprintBacklog;

    public Developer(String name, String lastName, double salary, String position) {
        this.name = name;
        this.lastName = lastName;
        this.salary = salary;
        this.position = position;
        this.doneTaskCount = 0;
        this.score = 0;
        this.assignedSprintBacklog = null;
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

    public int getDoneTaskCount() {
        return doneTaskCount;
    }

    public int getScore() {
        return score;
    }

    public SprintBacklog getAssignedSprintBacklog() {
        return assignedSprintBacklog;
    }

    public void assignSprintBacklog(SprintBacklog sprintBacklog) {
        this.assignedSprintBacklog = sprintBacklog;
    }

    public void markTaskAsValidate(Task task) {
        if (task.getStatus() == Status.DONE) {
            doneTaskCount++;
            score += task.getStoryPoints();
        }
    }
}
