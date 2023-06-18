package com.malarska.knightsgame.service;

import com.malarska.knightsgame.domain.Task;
import com.malarska.knightsgame.domain.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Locale;

@Service
public class TaskFormater implements Formatter<Task> {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task parse(String idAsStr, Locale locale) throws ParseException {
        Integer id = Integer.parseInt(idAsStr);
        return taskRepository.getTask(id);
    }

    @Override
    public String print(Task object, Locale locale) {
        return object.toString();
    }
}
