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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CourseEdition getEdition() {
        return edition;
    }

    public void setEdition(CourseEdition edition) {
        this.edition = edition;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDateTime applicationDate) {
        this.applicationDate = applicationDate;
    }

    public ProcessingState getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(ProcessingState applicationState) {
        this.applicationState = applicationState;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
