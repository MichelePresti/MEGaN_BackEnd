package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Module;

import java.util.Collection;
import java.util.stream.Collectors;

public class ModuleDTO {

    private int id;
    private String name;
    private String subject;
    private PersonDTO teacher;
    private int durationHours;
    private Collection<LessonDTO> lessons;
    private Collection<SessionDTO> sessions;

    public ModuleDTO(){}

    public ModuleDTO(Module module){
        this.id = module.getId();
        this.name = module.getName();
        this.subject = module.getSubject();
        this.teacher = new PersonDTO(module.getTeacher());
        this.durationHours = module.getDurationHours();
        this.lessons = module.getLessons().stream().map(LessonDTO::new).collect(Collectors.toList());
        this.sessions = module.getSessions().stream().map(SessionDTO::new).collect(Collectors.toList());
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

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public PersonDTO getTeacher() {
        return teacher;
    }

    public void setTeacher(PersonDTO teacher) {
        this.teacher = teacher;
    }

    public int getDurationHours() {
        return durationHours;
    }

    public void setDurationHours(int durationHours) {
        this.durationHours = durationHours;
    }

    public Collection<LessonDTO> getLessons() {
        return lessons;
    }

    public void setLessons(Collection<LessonDTO> lessons) {
        this.lessons = lessons;
    }

    public Collection<SessionDTO> getSessions() {
        return sessions;
    }

    public void setSessions(Collection<SessionDTO> sessions) {
        this.sessions = sessions;
    }
}
