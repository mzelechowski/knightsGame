package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;


    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);

    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void deleteKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {

        int sum = knightRepository.getAllKnights().stream().filter(k -> k.getTask().isCompleted())
                .mapToInt(k -> k.getTask().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(k -> k.getTask().isCompleted())
                .forEach(k -> k.setTask(null));

        return sum;

    }
}
