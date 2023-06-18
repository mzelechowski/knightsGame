package com.malarska.knightsgame;

import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import com.malarska.knightsgame.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
@AllArgsConstructor
public class Starter implements CommandLineRunner {

    @Qualifier("inMemoryKnightRepository")
    KnightRepository knightRepository;

    TaskRepository taskRepository;
    TaskService taskService;


    @Override
    public void run(String... args) throws Exception {

        taskRepository.createRandomTask();
        taskRepository.createRandomTask();
        taskRepository.createRandomTask();
        taskRepository.createRandomTask();
        taskRepository.createRandomTask();
        System.out.println(knightRepository);
//        taskService.assignRandomQuest("Władysław");
//        taskService.assignRandomQuest("Stanisław");
//        System.out.println(KnightRepository);
//        System.out.println(taskRepository);

    }
}
