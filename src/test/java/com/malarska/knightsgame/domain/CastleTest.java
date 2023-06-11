package com.malarska.knightsgame.domain;

import com.malarska.knightsgame.domain.Castle;
import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.Task;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CastleTest {

    @Test
    public void castleToStringMessage() {
        Knight knight=new Knight();
        knight.setTask(new Task());
        Castle castle = new Castle(knight, "East Watch 3773");
        String except = "Here stands a castle called East Watch 3773, in which live knight called: Knight with name: Richard ( 29 ). Task: Help princess.";
        assertEquals(except, castle.toString());
    }
}
