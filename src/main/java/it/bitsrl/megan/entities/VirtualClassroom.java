package it.bitsrl.megan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIRTUAL")
public class VirtualClassroom extends Classroom{

    private String platform;
    private String link;
    private String password;

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

    public VirtualClassroom(){}
    public VirtualClassroom(Integer id){
        super(id);
    }
    @Override
    public boolean hasComputer() {
        return true;
    }

    public VirtualClassroom(Integer id, String name, int size, String platform, String link, String password) {
        super(id, name, size);
        this.platform = platform;
        this.link = link;
        this.password = password;
    }

    @Override
    public boolean hasProjectors() {
        return true;
    }
}
