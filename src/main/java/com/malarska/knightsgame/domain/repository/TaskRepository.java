package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Repository
public class TaskRepository {

    Random rand = new Random();
    List<Task> taskList = new ArrayList<>();

    public void createTask(String description) {
        taskList.add(new Task(description));
    }

    public List<Task> getAll() {
        return taskList;
    }

    public void deleteTask(Task task) {
        taskList.remove(task);
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "TaskRepository{" +
                "taskList=" + taskList +
                '}';
    }

    //@Scheduled(fixedDelay = 1000) // czas liczony gdy metoda wywoła się i zakończy działanie, dopiero wtedy liczy sekundę
    //@Scheduled(fixedRate = 1000, initialDelay = 3000)  // czas liczony jest od momentu wywołąnia metody, nie czeka na zakonczenie metody
    //@Scheduled(fixedDelayString = "${taskCreationDelay}")  //pobierane wartości ze zwmiennej z application.properties
    public void createRandomTask() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Saved princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill dragon");
        descriptions.add("Find treasure");
        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("Create TASK  with description: "+ description);
        createTask(description);
    }
}
