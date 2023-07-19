package com.malarska.knightsgame;

import com.malarska.knightsgame.domain.PlayerInformation;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.domain.repository.PlayerInformationRepository;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import com.malarska.knightsgame.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Scope("singleton")
@AllArgsConstructor
public class Starter implements CommandLineRunner {
    KnightRepository knightRepository;
    TaskRepository taskRepository;
    TaskService taskService;
    PlayerInformationRepository playerInformationRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {


        taskRepository.createRandomTask();
        knightRepository.createKnight("Władysław", 32);
        knightRepository.createKnight("Stanisław", 33);
        playerInformationRepository.createPlayerInformation(new PlayerInformation());
//        System.out.println(knightRepository);
        //taskService.assignRandomQuest("Władysław");
        taskService.assignRandomQuest("Stanisław");
//        System.out.println(KnightRepository);
//        System.out.println(taskRepository);

    }
}
