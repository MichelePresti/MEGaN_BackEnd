package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Application;

public class ApplicationDTO {

    private int id;
    private PersonDTO student;
    private String applicationDate;
    private String applicationState;
    private String comments;

    public ApplicationDTO(){}
    public ApplicationDTO(Application application){
        this.id = application.getId();
        this.student = new PersonDTO(application.getStudent());
        this.applicationState = application.getApplicationState().toString();
        this.applicationDate = application.getApplicationDate().toString();
        this.comments = application.getComments();
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

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApplicationState() {
        return applicationState;
    }

    public void setApplicationState(String applicationState) {
        this.applicationState = applicationState;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
