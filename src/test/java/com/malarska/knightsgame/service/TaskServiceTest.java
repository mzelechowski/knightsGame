package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.domain.repository.TaskRepository;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ExtendWith(MockitoExtension.class)
class TaskServiceTest {

    @Mock
    TaskRepository repositoryMock;

    @Test
    public void returnsNotStartedTasks() {
        List<Task> tasks = new ArrayList<>();
        Task t1 = new Task("Test task 1");
        Task t2 = new Task("Test task 2");
        Task t3 = new Task("Test task 3");

        t2.setStarted(true);

        tasks.add(t1);
        tasks.add(t2);
        tasks.add(t3);

        when(repositoryMock.getAll()).thenReturn(tasks);

        TaskService ts = new TaskService();

        ts.setTaskRepository(repositoryMock);

        List<Task> allNotStartedTasks= ts.getAllNotStartedTasks();

        assertEquals("Size of returned quest", 2, allNotStartedTasks.size());
        assertThat(allNotStartedTasks, containsInAnyOrder(t1,t3));
    }
}