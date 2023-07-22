package com.malarska.knightsgame.domain;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String description;

    private int reward = 100;

    protected int lengthInSeconds = 10;

    private boolean started = false;

    private boolean completed = false;

    protected LocalDateTime startDate;

    public Task() {

    }

    public Task(int i, String testTask) {
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getLengthInSeconds() {
        return lengthInSeconds;
    }

    public void setLengthInSeconds(int lenghtInSeconds) {
        this.lengthInSeconds = lenghtInSeconds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(boolean started) {
        if (started) {
            this.startDate = LocalDateTime.now();
        }

        this.started = started;
    }

    public boolean isCompleted() {
        if (this.completed) {
            return this.completed;
        } else {
            LocalDateTime now = LocalDateTime.now();

            LocalDateTime questEndDate = this.startDate.plusSeconds(this.lengthInSeconds);

            boolean isAfter = now.isAfter(questEndDate);

            if (isAfter) {
                this.completed = true;
            }

            return isAfter;
        }
    }
    public boolean isComp() {
        return this.completed;
    }

    public Task(String description) {
             this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return  description;
    }


}
