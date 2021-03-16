package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Table(name="course")
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private double cost;
    private String program;
    private boolean certification;
    private String category;

    @OneToMany(mappedBy="course")
    private Collection<CourseEdition> editions;

    public int getId() {
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

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public boolean isCertification() {
        return certification;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Collection<CourseEdition> getEditions() {
        return editions;
    }

    public void setEditions(Collection<CourseEdition> editions) {
        this.editions = editions;
    }
}
