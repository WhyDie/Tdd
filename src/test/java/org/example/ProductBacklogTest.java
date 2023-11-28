package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductBacklogTest {
    @Test
    public void canAddTaskToProductBacklog() {
        ProductBacklog backlog = new ProductBacklog();
        Task task = new Task("Task#", 5);

        backlog.addTask(task);

        assertTrue(backlog.getTasks().contains(task));
    }

    @Test
    public void canDeleteTaskFromProductBacklog() {
        ProductBacklog backlog = new ProductBacklog();
        Task task = new Task("Task#", 5);
        backlog.addTask(task);

        backlog.deleteTask(task);

        assertFalse(backlog.getTasks().contains(task));
    }



}