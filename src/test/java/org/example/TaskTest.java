package org.example;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {
    @Test
    public void newTaskShouldHaveToDoStatus() {
        Task task = new Task("Task#", 5);
        assertEquals(Status.TO_DO, task.getStatus());
    }
    @Test
    public void newTaskShouldHaveCorrectName() {
        Task task = new Task("Task#", 5);
        assertEquals("Task#1", task.getName());
    }
    @Test
    public void newTaskShouldHaveValidStoryPoints() {
        Task task = new Task("Task#", 8);
        assertTrue(List.of(1, 2, 3, 5, 8, 13, 20, 100).contains(task.getStoryPoints()));
    }

}