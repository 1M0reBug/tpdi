package com.ninja_squad.tpdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ninja_squad.tpdi.service.SpectacleService;

import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jordan on 21/05/15.
 */
@Component
public class SpectacleCtrl {

    private SpectacleService service;

    @Autowired
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
