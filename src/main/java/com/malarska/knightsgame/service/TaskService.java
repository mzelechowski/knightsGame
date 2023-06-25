package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


@Service
public class TaskService {

    @Qualifier("inMemoryKnightRepository")
    KnightRepository knightRepository;


    TaskRepository taskRepository;

    @Autowired
    public void setTaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    final static Random rand = new Random();

    public void assignRandomQuest(String name) {
        List<Task> allTasks = taskRepository.getAll();
        Task randomTask = taskRepository.getAll().get(rand.nextInt(allTasks.size()));
        knightRepository.getKnight(name).ifPresent(knight -> knight.setTask(randomTask));
        taskRepository.deleteTask(randomTask);
    }

    public List<Task> getAllNotStartedTasks() {
        return taskRepository.getAll().stream().filter(t -> !t.isStarted()).collect(Collectors.toList());
    }

    public void update(Task task) {
        taskRepository.update(task);
    }

    public boolean isTaskCompleted(Task task) {
        return task.isCompleted();
    }
}
