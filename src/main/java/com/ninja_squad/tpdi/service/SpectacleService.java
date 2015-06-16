package com.ninja_squad.tpdi.service;

import com.ninja_squad.tpdi.dao.SpectacleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jordan on 21/05/15.
 */
@Service
public class SpectacleService implements ISpectacleService {

    private SpectacleDao dao;

    @Autowired
    public SpectacleService(SpectacleDao _dao) {
        dao = _dao;
    }

    public String trouver(String search) {
        Stream<String> lines = null;
        try {
            lines = dao.trouver(search);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Optional<String> element = lines.filter( l -> l.contains(search)).findFirst();
        return element.isPresent()?element.get():"empty";
    }

    private boolean isUnique(String bla) {
        return true;
    }

    public boolean creer(String toCreate) {
        if(isUnique(toCreate)){
            try {
                dao.creer(toCreate);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            return true;
        } else {
            return false;
        }
    }
}
