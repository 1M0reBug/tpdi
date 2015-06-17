package com.ninja_squad.tpdi.dao;

import com.ninja_squad.tpdi.domain.Spectacle;
import com.ninja_squad.tpdi.service.SpectacleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jordan on 21/05/15.
 */
@Repository
public class SpectacleDao {
    @PersistenceContext
    private EntityManager em;


    public Stream<String> trouver() throws IOException {
        String jpql = "SELECT s FROM Spectacle AS s ORDER BY s.titre";
        TypedQuery<Spectacle> query = em.createQuery(jpql, Spectacle.class);

        List<Spectacle> resultList = query.getResultList();
        return resultList.stream().map(Spectacle::getTitre);
    }

    @Transactional
    public void creer(String toCreate) throws IOException {

        Spectacle tmp = new Spectacle();
        tmp.setTitre(toCreate);
        em.persist(tmp);

    }
}
