package controller;

import service.SpectacleService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jordan on 21/05/15.
 */
public class SpectacleCtrl {

    private SpectacleService service;

    public SpectacleCtrl(SpectacleService _service) {
        service = _service;
    }

    public void init() throws IOException {
        boolean ok = true;
        while (ok){
            System.out.print("> ");

            Scanner scan = new Scanner(System.in);

            String read = scan.next();
            if(read.equals("quitter")) {
                ok = false;
            } else if (read.equals("trouver")){
                System.out.println(service.trouver(scan.nextLine().trim()));
            } else if(read.equals("creer")) {
                service.creer(scan.nextLine().trim());
            }
        }
    }
}
