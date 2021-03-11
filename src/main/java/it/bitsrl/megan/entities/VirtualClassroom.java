package it.bitsrl.megan.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("VIRTUAL")
public class VirtualClassroom extends Classroom{

    private String platform;
    private String link;
    private String password;

    public VirtualClassroom(long id){
        super(id);
    }
    @Override
    public boolean hasComputer() {
        return true;
    }

    @Override
    public boolean hasProjectors() {
        return true;
    }
}
