package com.malarska.knightsgame.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Castle {

    @Value("${my.castle.name:West Gate 5000}")
    private String name;

    Knight knight;

    @Autowired
    public Castle(Knight knight) {
        this.knight=knight;
    }

    Castle(Knight knight, String name) {
        this.name = name;
        this.knight = knight;
    }

    public void build() {
        System.out.println("\t\u2191 A castle " + name + " was built \u2191.");
    }

    public void tearDown() {
        System.out.println("\t\u2193 We're about to demolish the castle " + name + " \u2193.");
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Here stands a castle called " + this.name + ", in which live knight called: " + knight;
    }
}