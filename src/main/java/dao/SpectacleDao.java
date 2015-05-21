package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by jordan on 21/05/15.
 */
public class SpectacleDao {
    private String filename;

    public SpectacleDao(String _filename) {
        filename = _filename;
    }

    public String trouver(String search) throws IOException {
        Stream<String> lines = Files.lines(Paths.get(filename));
        Optional<String> element = lines.filter( l -> l.contains(search)).findFirst();
        lines.close();
        return element.isPresent()?element.get():"empty";
    }

    public String creer(String toCreate) throws IOException {

        toCreate += System.lineSeparator();
        Files.write(Paths.get(filename), toCreate.getBytes(), StandardOpenOption.APPEND);

        return toCreate;
    }
}
