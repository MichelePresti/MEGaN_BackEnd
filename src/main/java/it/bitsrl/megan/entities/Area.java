package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="area")
public class Area {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private String description;

    @OneToMany(mappedBy="area")
    private Set<Ability> abilities;

}
