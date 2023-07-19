package com.malarska.knightsgame.config;

import com.malarska.knightsgame.domain.repository.DBKnightRepository;
import com.malarska.knightsgame.domain.repository.InMemoryRepository;
import com.malarska.knightsgame.domain.repository.KnightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class MainConfig {


    @Bean(name="inMemoryKnightRepository")
    @Profile("dev")
    public KnightRepository createInMemoryRepo(){
        KnightRepository repo = new InMemoryRepository();
        return repo;
    }

    @Bean(name="dBKnightRepository")
    @Profile("prod")
    public KnightRepository createDBKnightRepo(){
        KnightRepository repo = new DBKnightRepository();
        return repo;
    }


}
