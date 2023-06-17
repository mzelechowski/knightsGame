package com.malarska.knightsgame.utils;

import java.util.Set;

public class Ids {

    public static int generateNewId(Set<Integer> keySoFar) {
        if (keySoFar.isEmpty()) {
            return 0;
        } else {
            Integer integer = keySoFar
                    .stream()
                    .max(Integer::compareTo).get();
            return integer + 1;
        }
    }
}
