package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;


public class DBKnightRepository implements KnightRepository {


    @Override
    public void createKnight(String name, int age) {
        System.out.println("Uzywam bazy danych");
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    @Override
    public Collection<Knight> getAllKnights() {
        System.out.println("Uzywam bazy danych");
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    @Override
    public Knight getKnight(String name) {
        System.out.println("Uzywam bazy danych");
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    @Override
    public void deleteKnight(String name) {
        System.out.println("Uzywam bazy danych");
        throw new UnsupportedOperationException("Method not yet implemented");
    }

    @Override
    @PostConstruct
    public void build() {

    }

    @Override
    public void createKnight(Knight knight) {
        System.out.println("Uzywam bazy danych");
        throw new UnsupportedOperationException("Method not yet implemented");
    }
}
