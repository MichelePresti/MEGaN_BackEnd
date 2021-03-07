package it.bitsrl.megan.entities;


import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="module")
public class Module {

    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String subject;

    @ManyToOne
    private Person teacher;

    private int durationHours;

    @OneToMany(mappedBy="module")
    private List<Lesson> lessons;

    @ManyToOne
    private CourseEdition edition;

    @OneToMany(mappedBy="module")
    private Collection<Session> sessions;
}
