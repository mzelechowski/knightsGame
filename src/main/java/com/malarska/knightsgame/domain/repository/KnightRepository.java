package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Knight;
import java.util.Collection;

public interface KnightRepository {
    void createKnight(String name, int age);

    Collection<Knight> getAllKnights();

    Knight getKnight(String name);

    void deleteKnight(String name);

    void build();

    void createKnight(Knight knight);

}
