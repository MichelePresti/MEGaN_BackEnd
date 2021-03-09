package it.bitsrl.megan.entities;


import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="application")
public class Application {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private CourseEdition edition;

    @ManyToOne
    private Student student;

    private LocalDateTime applicationDate;

    @Enumerated(EnumType.ORDINAL)
    private ProcessingState applicationState;

    private String comments;

}
