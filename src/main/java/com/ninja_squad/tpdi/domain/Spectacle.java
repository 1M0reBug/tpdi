package com.ninja_squad.tpdi.domain;

import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="Spectacle2")
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

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public Spectacle() {
    }
}
