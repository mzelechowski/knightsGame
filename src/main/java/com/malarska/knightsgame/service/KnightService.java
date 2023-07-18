package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.PlayerInformation;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.domain.repository.PlayerInformationRepository;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    PlayerInformationRepository playerInformation;


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

        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getTask() != null) {
                return knight.getTask().isCompleted();
            } else {
                return false;
            }
        };

        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getTask().getReward())
                .sum();

        knightRepository.getAllKnights().stream().filter(knightPredicate).forEach(knight -> {
            knight.setTask(null);
        });

        return sum;
    }

    @Transactional
    public void getMyGold() {

        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
                    if (knight.getTask() != null) {
                        boolean completed = knight.getTask().isCompleted();

                        if (completed) {
                            taskRepository.update(knight.getTask());
                        }
                    }
                }
        );
        PlayerInformation first = playerInformation.getFirst();
        int currentGold = first.getGold();
        first.setGold(currentGold + collectRewards());
    }
}
