package com.malarska.knightsgame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {

    @Test
    public void settingStartedFlagToFalseShouldSetStartDate() {
        Task task = new Task(1, "Test task");

        task.setStarted(true);

        assertNotNull(task.startDate);

    }

    @Test
    public void questShouldBeCompleted() {
        Task task = new Task(1, "Test task");
        task.setStarted(true);
        task.lenghtInSeconds = -60;
        assertTrue(task.isCompleted());
    }

    @Test
    public void questShouldNotBeCompleted() {
        Task task = new Task(1, "Test task");
        task.setStarted(true);
        task.lenghtInSeconds = 2000;
        assertFalse(task.isCompleted());
    }

}