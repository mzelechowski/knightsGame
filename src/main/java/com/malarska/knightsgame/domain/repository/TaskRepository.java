package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.utils.Ids;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;


@Repository
public class TaskRepository {

    Random rand = new Random();

    Map<Integer, Task> tasks = new HashMap<>();


    public void createTask(String description) {
        int newId = Ids.generateNewId(tasks.keySet());
        tasks.put(newId, new Task(newId, description));
    }

    public List<Task> getAll() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteTask(Task task) {
        tasks.remove(task.getId());
    }

    @PostConstruct
    public void init() {
    }

    @Override
    public String toString() {
        return "TaskRepository{" +
                "taskList=" + tasks +
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
        descriptions.add("Find and Kill Goblins");
        String description = descriptions.get(rand.nextInt(descriptions.size()));
        System.out.println("(From method random task)Create TASK  with description: " + description);
        createTask(description);
    }

    public void update(Task task) {
        tasks.put(task.getId(), task);
    }

    public Task getTask(Integer id) {
        return tasks.get(id);
    }
}
