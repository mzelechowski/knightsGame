package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.utils.Ids;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;


public class InMemoryRepository implements KnightRepository {

    Map<Integer, Knight> knights = new HashMap<>();

    public InMemoryRepository() {
    }

    @Override
    public void createKnight(String name, int age) {
        Knight newKnight = new Knight(name, age);
        newKnight.setId(Ids.generateNewId(knights.keySet()));
        knights.put(newKnight.getId(), newKnight);
    }

    @Override
    public Collection<Knight> getAllKnights(){
        return knights.values();
    }

    @Override
    public Optional<Knight> getKnight(String name){
        Optional<Knight> knightByName = knights.values().stream().filter(k -> k.getName().equals(name)).findAny();
        return knightByName;
    }

    @Override
    public void deleteKnight(Integer id){
        knights.remove(id);
    }

    @Override
    @PostConstruct
    public void build() {
        createKnight("Władysław", 29);
        createKnight("Stanisław", 44);
        createKnight("Bogusław", 44);
        createKnight("Ryszard", 66);
    }

    @Override
    public void createKnight(Knight knight) {
        knight.setId(Ids.generateNewId(knights.keySet()));
        knights.put(knight.getId(), knight);
    }

    @Override
    public Knight getKnightById(Integer id) {
        return knights.get(id);
    }

    @Override
    public String toString() {
        return "InMemoryRepository{"  +
                "knights=" + knights +
                '}';
    }
}