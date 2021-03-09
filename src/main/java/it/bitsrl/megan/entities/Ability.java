package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="ability")
public class Ability {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToOne
    private Area area;

    @OneToMany(mappedBy="ability")
    private Collection<Skill> skills;

    private String description;

}
