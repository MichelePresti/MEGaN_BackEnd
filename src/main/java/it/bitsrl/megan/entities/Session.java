package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name="session")
public class Session {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.ORDINAL)
    private DayWeek day;

    private LocalTime start;

    private LocalTime end;

    @ManyToOne
    private Module module;
}
