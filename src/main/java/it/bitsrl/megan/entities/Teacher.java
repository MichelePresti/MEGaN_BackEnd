package it.bitsrl.megan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import java.util.Collection;

@Entity
@DiscriminatorValue("TEACHER")

public class Teacher extends Person{

    @OneToMany(mappedBy="teacher")
    private Collection<Module> modules;

    private double costPerHour;
}
