package com.malarska.knightsgame.domain;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;


public class Knight {

    private int id;

    @NotNull
    @Size(min=2, max=40)
    private String name;

    @NotNull
    @Range(min=18, max=60)
    private int age;

    private int experience;

    private Task task;

    public Knight() {
        this.experience=1;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
        this.experience=1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        task.setStarted(true);
        this.task = task;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return age == knight.age;
    }

    @Override
    public int hashCode() {
        return Objects.hash(age);
    }

    @Override
    public String toString() {
        return "Knight with name: " + name + " ( " + age + " ). Task: " + task + ".";
    }

}