package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Enrollment;

public class EnrollmentDTO {

    private int id;
    private PersonDTO student;
    private String enrollDate;
    private boolean isPayed;
    private double grade;

    public EnrollmentDTO(){}

    public EnrollmentDTO(Enrollment enrollment){
        this.id = enrollment.getId();
        this.student = new PersonDTO(enrollment.getStudent());
        this.enrollDate = enrollment.getEnrollDate().toString();
        this.isPayed = enrollment.getPayed();
        this.grade = enrollment.getGrade();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public PersonDTO getStudent() {
        return student;
    }

    public void setStudent(PersonDTO student) {
        this.student = student;
    }

    public String getEnrollDate() {
        return enrollDate;
    }

    public void setEnrollDate(String enrollDate) {
        this.enrollDate = enrollDate;
    }

    public boolean isPayed() {
        return isPayed;
    }

    public void setPayed(boolean payed) {
        isPayed = payed;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}
