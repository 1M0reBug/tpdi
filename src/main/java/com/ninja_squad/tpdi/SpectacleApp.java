package com.ninja_squad.tpdi;

import com.ninja_squad.tpdi.controller.SpectacleCtrl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

/**
 * Created by jordan on 21/05/15.
 */

public class SpectacleApp {

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        SpectacleCtrl ctrl = ctx.getBean(SpectacleCtrl.class);
        ctrl.init();
    }
}
