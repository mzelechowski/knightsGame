package com.malarska.knightsgame.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// komentuje scope aby z componentu PlayerInformtion zrobić singletona.
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class PlayerInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private int gold=0;


    public PlayerInformation() {

    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
