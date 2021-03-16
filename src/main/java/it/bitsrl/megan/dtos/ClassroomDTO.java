package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.Classroom;
import it.bitsrl.megan.entities.Equipment;
import it.bitsrl.megan.entities.RealClassroom;
import it.bitsrl.megan.entities.VirtualClassroom;

public class ClassroomDTO {

    private long id;
    private String name;
    private int size;
    private String classroomType;
    private String tech;
    private String platform;
    private String link;
    private String password;

    public ClassroomDTO() {
    }

    public ClassroomDTO(Classroom classroom) {
        this.id = classroom.getId();
        this.name = classroom.getName();
        this.size = classroom.getSize();
        if (classroom instanceof RealClassroom) {
            this.classroomType = "REAL";
            this.tech = ((RealClassroom) classroom).getTech().toString();
            this.platform = "";
            this.link = "";
            this.password = "";
        } else {
            this.classroomType = "VIRTUAL";
            this.platform = ((VirtualClassroom) classroom).getPlatform();
            this.link = ((VirtualClassroom) classroom).getLink();
            this.password = ((VirtualClassroom) classroom).getPassword();
            this.tech = "";

        }
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getClassroomType() {
        return classroomType;
    }

    public void setClassroomType(String classroomType) {
        this.classroomType = classroomType;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
