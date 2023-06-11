package com.malarska.knightsgame.domain;

import org.springframework.stereotype.Component;

@Component
public class Task {
    private String description;

    public Task() {
        this.description = "Save princess";
    }

    @Override
    public String toString() {
        return description;
    }
}
