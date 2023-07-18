package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.Task;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;


@Repository
public class TaskRepository {

    @PersistenceContext
    private EntityManager em;

    Random rand = new Random();

    @Transactional
    public void createTask(String description) {
        Task newTask=new Task(description);
        em.persist(newTask);
    }

    public List<Task> getAll() {
        return em.createQuery("from Task", Task.class).getResultList();
    }

    @Transactional
    public void deleteTask(Task task) {
        em.remove(task);
    }

    //@Scheduled(fixedDelay = 1000) // czas liczony gdy metoda wywoła się i zakończy działanie, dopiero wtedy liczy sekundę
    //@Scheduled(fixedRate = 1000, initialDelay = 3000)  // czas liczony jest od momentu wywołąnia metody, nie czeka na zakonczenie metody
    @Scheduled(fixedDelayString = "${taskCreationDelay}")  //pobierane wartości ze zwmiennej z application.properties
    @Transactional
    public void createRandomTask() {
        List<String> descriptions = new ArrayList<>();

        descriptions.add("Saved princess");
        descriptions.add("Take part in the tournament");
        descriptions.add("Kill dragon");
        descriptions.add("Find treasure");
        descriptions.add("Find and Kill Goblins");

        String description = descriptions.get(rand.nextInt(descriptions.size()));
        createTask(description);
    }

    @Transactional
    public void update(Task task) {
        em.merge(task);
    }

    @Transactional
    public Task getTask(Integer id) {
        return em.find(Task.class, id);
    }
}
