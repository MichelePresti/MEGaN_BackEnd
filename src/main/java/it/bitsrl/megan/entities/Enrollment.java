package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="enrollment")
public class Enrollment {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Student student;

    @ManyToOne
    private CourseEdition courseEdition;

    private LocalDate enrollDate;

    private Boolean isPayed;
    private Double grade;

    public Enrollment(Student student, CourseEdition courseEdition, LocalDate enrollDate,
                      Boolean isPayed, Double grade) {

        this.student = student;
        this.courseEdition = courseEdition;
        this.enrollDate = enrollDate;
        this.isPayed = isPayed;
        this.grade = grade;

    }

    public Enrollment(){}

    public Student getStudent() {
        return student;
    }

    public CourseEdition getCourseEdition() {
        return courseEdition;
    }

    public LocalDate getEnrollDate() {
        return enrollDate;
    }

    public Boolean getPayed() {
        return isPayed;
    }

    public Double getGrade() {
        return grade;
    }
}
