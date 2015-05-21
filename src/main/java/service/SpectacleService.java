package service;

import dao.SpectacleDao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jordan on 21/05/15.
 */
public class SpectacleService {

    private SpectacleDao dao;

    public SpectacleService(SpectacleDao _dao) {
        dao = _dao;
    }

    public String trouver(String search) throws IOException {
        return dao.trouver(search);
    }

    public String creer(String toCreate) throws IOException {
        return dao.creer(toCreate);
    }
}
