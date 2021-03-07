package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="skill")
public class Skill {


    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Ability ability;

    @Enumerated(EnumType.ORDINAL)
    private Level level;

    private boolean certified;

    @ManyToOne
    private Person person;

}
