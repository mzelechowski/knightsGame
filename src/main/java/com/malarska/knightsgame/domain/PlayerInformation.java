package com.malarska.knightsgame.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component
// komentuje scope aby z componentu PlayerInformtion zrobić singletona.
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)

public class PlayerInformation {

    private int gold=0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
