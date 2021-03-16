package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Presence;

public class PresenceDTO {

    private int id;
    private PersonDTO student;
    private String startDate;
    private String endDate;

    public PresenceDTO(){}

    public PresenceDTO(Presence presence){
        this.id = presence.getId();
        this.student = new PersonDTO(presence.getStudent());
        this.startDate = presence.getStartDate().toString();
        this.endDate = presence.getEndDate().toString();
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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
