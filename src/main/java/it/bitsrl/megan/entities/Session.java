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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DayWeek getDay() {
        return day;
    }

    public void setDay(DayWeek day) {
        this.day = day;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
