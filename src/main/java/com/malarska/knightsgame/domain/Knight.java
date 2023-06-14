package com.malarska.knightsgame.domain;

import java.util.Objects;

public class Knight {

    private String name;

    private int age;

    private Task task;

    public Knight() {
        this.name = "Richard";
        this.age = 44;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Knight(String name, int age) {
        this.name = name;
        this.age = age;
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

    public void setTask(Task task) {
        System.out.println("Spring sets task for KNIGHT called: " + name);
        this.task = task;
    }

    @Override
    public String toString() {
        return "Knight with name: " + name + " ( " + age + " ). Task: " + task + ".";
    }

    public int getAge() {
        return this.age;
    }
}