package it.bitsrl.megan.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@DiscriminatorValue("EMPLOYEE")
@Table(name="employee")
public class Employee extends Person{

    private String role;
    private double salary;

    @OneToMany(mappedBy="editionManager")
    private Collection<CourseEdition> editionsToManage;

}
