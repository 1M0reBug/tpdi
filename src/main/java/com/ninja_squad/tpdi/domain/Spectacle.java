package com.ninja_squad.tpdi.domain;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity

public class Spectacle {
    @Id
    // name correspond au nom de la séquence utilisée
    // sequenceName est le nom de la séquence utilisé dans la BDD
    @SequenceGenerator(name = "seq", sequenceName = "spectacle_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
    private Long id;

    private String titre;

    public Long getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    protected Spectacle() {
    }


}
