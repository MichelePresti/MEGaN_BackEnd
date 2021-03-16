package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Lesson;

import java.util.Collection;
import java.util.stream.Collectors;

public class LessonDTO {

    private int id;
    private String subject;
    private String start;
    private String end;
    private PersonDTO teacher;
    private Collection<PresenceDTO> presences;

    public LessonDTO(){}

    public LessonDTO(Lesson lesson){
        this.id = lesson.getId();
        this.subject = lesson.getSubject();
        this.start = lesson.getStart().toString();
        this.end = lesson.getEnd().toString();
        this.teacher = new PersonDTO(lesson.getTeacher());
        this.presences = lesson.getPresences().stream().map(PresenceDTO::new).collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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

    public PersonDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonDTO teacher) {
        this.teacher = teacher;
    }

    public Collection<PresenceDTO> getPresences() {
        return presences;
    }

    public void setPresences(Collection<PresenceDTO> presences) {
        this.presences = presences;
    }
}
