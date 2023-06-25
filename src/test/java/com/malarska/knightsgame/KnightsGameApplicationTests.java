package com.malarska.knightsgame;

import com.malarska.knightsgame.domain.Knight;
import com.malarska.knightsgame.domain.repository.InMemoryRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class KnightsGameApplicationTests {

//    @Autowired
//    Knight knight;
//
//    @Autowired
//    InMemoryRepository inMemoryRepository;
//
//    @Test
//    public void contextLoads() {
//    }
//
//    @Test
//    public void testCastle() {
//        String except = "Znajduje sie tu zamek o nazwie InMemoryRepository Black. Zamieszkaly przez rycerza Rycerz o imieniu Lancelot(29). Ma za zadanie: Uratuj ksiezniczke";
//        assertEquals(except, inMemoryRepository.toString());
//    }
}
