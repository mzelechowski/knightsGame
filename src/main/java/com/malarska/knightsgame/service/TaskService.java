package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class TaskService {

    @Qualifier("inMemoryKnightRepository")
    KnightRepository knightRepository;

    TaskRepository taskRepository;

    final static Random rand = new Random();

    public void assignRandomQuest(String name) {
        List<Task> allTasks = taskRepository.getAll();
        Task randomTask = taskRepository.getAll().get(rand.nextInt(allTasks.size()));
        knightRepository.getKnight(name).ifPresent(knight -> knight.setTask(randomTask));
        taskRepository.deleteTask(randomTask);
    }
}
