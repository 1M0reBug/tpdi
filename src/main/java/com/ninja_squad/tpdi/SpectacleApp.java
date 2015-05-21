package com.ninja_squad.tpdi;

import controller.SpectacleCtrl;
import dao.SpectacleDao;
import service.SpectacleService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * Created by jordan on 21/05/15.
 */
public class SpectacleApp {

    private static String filename = "data.txt";

    public static void main(String[] args) throws IOException {

        SpectacleDao dao = new SpectacleDao(filename);
        SpectacleService service = new SpectacleService(dao);
        SpectacleCtrl ctrl = new SpectacleCtrl(service);

        ctrl.init();
    }
}
