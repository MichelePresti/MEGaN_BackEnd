package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.DayWeek;
import it.bitsrl.megan.entities.Session;

public class SessionDTO {

    private int id;
    private String day;
    private String start;
    private String end;

    public SessionDTO(){}

    public SessionDTO(Session session){
        this.id = session.getId();
        this.day = session.getDay().toString();
        this.start = session.getStart().toString();
        this.end = session.getEnd().toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }
}
