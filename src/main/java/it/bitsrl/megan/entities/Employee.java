package it.bitsrl.megan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@DiscriminatorValue("EMPLOYEE")
public class Employee extends Person{

    private String role;
    private double salary;

    @OneToMany(mappedBy="editionManager")
    private Collection<CourseEdition> editionsToManage;

}
