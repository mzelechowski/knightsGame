package com.malarska.knightsgame;

import com.malarska.knightsgame.domain.Castle;
import com.malarska.knightsgame.domain.Knight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KnightsGameApplicationTests {

    @Autowired
    Knight knight;

    @Autowired
    Castle castle;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCaste() {
        String except = "Here stands a castle called East Watch 3773, in which live knight called: Knight with name: Richard ( 29 ). Task: Help princess.";
        assertEquals(except, castle.toString());
    }

}
