package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Knight;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


public class InMemoryRepository implements KnightRepository {

    Map<String, Knight> knights = new HashMap<>();

    public InMemoryRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        knights.put(name, new Knight(name, age));
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }

    @Override
    public Knight getKnight(String name){
        return knights.get(name);
    }

    @Override
    public void deleteKnight(String name){
        knights.remove(name);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Władysław", 29);
        createKnight("Stanisław", 44);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{"  +
                "knights=" + knights +
                '}';
    }
}