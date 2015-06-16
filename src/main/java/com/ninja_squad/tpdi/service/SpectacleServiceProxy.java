package com.ninja_squad.tpdi.service;

/**
 * Created by jordan on 16/06/15.
 */
public class SpectacleServiceProxy implements ISpectacleService {


    private ISpectacleService service;

    public SpectacleServiceProxy(ISpectacleService _service) {
        service = _service;
    }

    public String trouver(String toFind) {
        System.out.println("Début de la transaction trouver");
        String trouve = service.trouver(toFind);
        System.out.println("fin de la transaction");
        return trouve;
    }

    public boolean creer(String toCreate) {
        System.out.println("Début de la transaction creer");
        try{
            service.trouver(toCreate);
        } catch(RuntimeException e) {
            System.out.println("Rollback");
            return false;
        }
        System.out.println("fin de la transaction");
        return true;
    }
}
