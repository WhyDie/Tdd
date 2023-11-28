package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SprintBacklogTest {
    @Test
    public void canAddTaskToSprintBacklog() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        Task task = new Task("Task#", 8);
        sprintBacklog.addTask(task);
        assertTrue(sprintBacklog.getTasks().contains(task));
    }

    @Test
    public void canDeleteTaskFromSprintBacklog() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        Task task = new Task("Task#", 8);
        sprintBacklog.addTask(task);

        sprintBacklog.deleteTask(task);

        assertFalse(sprintBacklog.getTasks().contains(task));
    }

    @Test
    public void canCalculateAvailableCapacity() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        Task completedTask1 = new Task("CompletedTask1#", 5);
        Task completedTask2 = new Task("CompletedTask2#", 13);
        sprintBacklog.addTask(completedTask1);
        sprintBacklog.addTask(completedTask2);

        assertEquals(13, sprintBacklog.calculateAvailableCapacity());
    }

    @Test
    public void availableCapacityShouldNotBeNegative() {
        SprintBacklog sprintBacklog = new SprintBacklog(20);
        assertEquals(0, sprintBacklog.calculateAvailableCapacity());
    }

}