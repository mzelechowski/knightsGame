package com.malarska.knightsgame.domain.repository;

import com.malarska.knightsgame.domain.PlayerInformation;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class PlayerInformationRepository {

    @PersistenceContext
    EntityManager em;

    @Transactional
    public void createPlayerInformation(PlayerInformation playerInformation) {

        PlayerInformation pi = new PlayerInformation();

        em.persist(pi);

    }

    public PlayerInformation getFirst() {
        return em.createQuery("from PlayerInformation", PlayerInformation.class).getResultList().get(0);
    }
}
