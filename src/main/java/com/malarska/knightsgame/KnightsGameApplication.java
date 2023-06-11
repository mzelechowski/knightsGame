package com.malarska.knightsgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;


@SpringBootApplication
@ImportResource("classpath:castle.properties")
//@ComponentScan({"com.malarska.knightsgame","com.malarska.component"})
//@ComponentScan(basePackageClasses = {Starter.class, Castle.class, Knight.class, Task.class, TestComponent.class})
public class KnightsGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(KnightsGameApplication.class, args);

    }

}

