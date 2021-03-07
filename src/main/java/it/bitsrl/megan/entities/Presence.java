package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="presence")
public class Presence {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private Lesson lesson;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

}
