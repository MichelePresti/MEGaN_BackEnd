package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name="module")
public class Module {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

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


    public Module(){}
    public Module(Integer id, String name, String subject, Person teacher, int durationHours, List<Lesson> lessons, CourseEdition edition, Collection<Session> sessions) {
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.teacher = teacher;
        this.durationHours = durationHours;
        this.lessons = lessons;
        this.edition = edition;
        this.sessions = sessions;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Person getTeacher() {
        return teacher;
    }

    public void setTeacher(Person teacher) {
        this.teacher = teacher;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }

    public CourseEdition getEdition() {
        return edition;
    }

    public void setEdition(CourseEdition edition) {
        this.edition = edition;
    }

    public Collection<Session> getSessions() {
        return sessions;
    }

    public void setSessions(Collection<Session> sessions) {
        this.sessions = sessions;
    }
}
