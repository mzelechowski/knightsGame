package com.malarska.knightsgame.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KnightTest {

    @Test
    public void testIfQuestMarkedAsStarted() {

        Knight knight = new Knight("Bolesław", 55);
        Task task = new Task("Example test task");

        knight.setTask(task);

        assertTrue(knight.getTask().isStarted());
    }
}