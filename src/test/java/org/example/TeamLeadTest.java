package org.example;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TeamLeadTest {
    @Test
    public void canMoveTasksToSprintBacklog() {
        ProductBacklog productBacklog = new ProductBacklog();
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        TeamLead teamLead = new TeamLead("Alice", "Johnson", 70000.0);

        Task highPriorityTask = new Task("HighPriorityTask#", 13);
        highPriorityTask.setPriority(Priority.HIGH);
        Task normalPriorityTask = new Task("NormalPriorityTask#", 5);
        normalPriorityTask.setPriority(Priority.NORMAL);

        productBacklog.addTask(highPriorityTask);
        productBacklog.addTask(normalPriorityTask);

        teamLead.moveTasksToSprintBacklog(productBacklog, sprintBacklog);

        assertEquals(2, sprintBacklog.getTasks().size());
    }

    @Test
    public void canMarkTaskAsDone() {
        TeamLead teamLead = new TeamLead("Bob", "Smith", 75000.0);
        Task task = new Task("Task#", 8);

        teamLead.markTaskAsDone(task);

        assertEquals(Status.TO_DO, task.getStatus());
    }

    @Test
    public void canInspectSprintBacklog() {
        SprintBacklog sprintBacklog = new SprintBacklog(50);
        TeamLead teamLead = new TeamLead("Charlie", "Brown", 80000.0);

        Task doneTask = new Task("DoneTask#", 13);
        doneTask.markAsDone();
        Task notDoneTask = new Task("NotDoneTask#", 5);

        sprintBacklog.addTask(doneTask);
        sprintBacklog.addTask(notDoneTask);

        teamLead.inspectSprintBacklog(sprintBacklog);

        assertEquals(1, sprintBacklog.getTasks().size());
        assertFalse(sprintBacklog.getTasks().contains(doneTask));
        assertTrue(sprintBacklog.getTasks().contains(notDoneTask));
    }

}