package com.malarska.knightsgame.utils;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


class IdsTest {

    @Test
    public void testEmptySet() {
        Integer result = Ids.generateNewId(Collections.emptySet());
        assertEquals(0, result);
    }


    @Test
    public void testGeneratedNewId() {
        Set<Integer> sample = new HashSet<>();
        sample.add(4);
        sample.add(5);
        sample.add(6);
        int result=Ids.generateNewId(sample);
        assertEquals(7, result);
    }
}