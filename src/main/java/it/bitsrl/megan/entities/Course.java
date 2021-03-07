package it.bitsrl.megan.entities;


import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private int duration;
    private double cost;
    private String program;
    private boolean certification;
    private String category;

    @OneToMany(mappedBy="course")
    private Collection<CourseEdition> editions;

}
