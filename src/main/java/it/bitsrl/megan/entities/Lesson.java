package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="lesson")
public class Lesson {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String subject;

    private LocalDateTime start;

    private LocalDateTime end;

    @ManyToOne
    private Teacher teacher;

    @OneToMany(mappedBy="lesson")
    private List<Presence> presences;

    @ManyToOne
    private Classroom classroom;

    @ManyToOne
    private Module module;

}
