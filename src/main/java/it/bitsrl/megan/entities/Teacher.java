package it.bitsrl.megan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@DiscriminatorValue("TEACHER")
@Table(name="teacher")
public class Teacher extends Person{

    @OneToMany(mappedBy="teacher")
    private Collection<Module> modules;

    private double costPerHour;
}
