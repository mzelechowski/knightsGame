package com.malarska.knightsgame;

import com.malarska.knightsgame.domain.Castle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    private Castle castle;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(castle);
    }
}
