package com.malarska.knightsgame.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Knight {

    private String name;

    private int age;

    private Task task;

    public Knight() {
        this.name = "Richard";
        this.age = 44;
    }


    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
    }
@Autowired
    public void setTask(Task task) {
        System.out.println("Spring sets task for KNIGHT called: " + name);
        this.task = task;
    }

    @Override
    public String toString() {
        return "Knight with name: " + name + " ( " + age + " ). Task: " + task + ".";
    }

}