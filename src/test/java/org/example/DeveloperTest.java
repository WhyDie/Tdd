package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeveloperTest {
    @Test
    public void canGetTaskFromSprintBacklog() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        Developer developer = new Developer("John", "Doe", 50000.0, "backend developer");
        developer.assignSprintBacklog(sprintBacklog);
        Task task = new Task("Task#", 8);
        sprintBacklog.addTask(task);
        assertEquals(1, sprintBacklog.getTasks().size());
        assertEquals(Status.TO_DO, task.getStatus());
    }

    @Test
    public void canMarkTaskAsValidate() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        Developer developer = new Developer("Jane", "Smith", 60000.0, "frontend developer");
        developer.assignSprintBacklog(sprintBacklog);
        Task task = new Task("Task#", 13);
        developer.markTaskAsValidate(task);
        assertEquals(0, developer.getDoneTaskCount());
        assertEquals(0, developer.getScore());
    }


}