package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Course;

public class CourseDTO {

    private int id;
    private String name;
    private double price;
    private String program;
    private boolean certification;
    private String category;

    public CourseDTO(){}
    public CourseDTO(Course course){
        this.id = course.getId();
        this.name = course.getName();
        this.price = course.getCost();
        this.program = course.getProgram();
        this.certification = course.isCertification();
        this.category = course.getCategory();
    }

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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
}
