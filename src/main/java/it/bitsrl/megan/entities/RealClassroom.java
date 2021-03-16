package it.bitsrl.megan.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("REAL")
public class RealClassroom extends Classroom{


    @Enumerated(EnumType.STRING)
    private Equipment tech;


    public RealClassroom(){}
    public RealClassroom(Integer id){
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

    public Equipment getTech(){
        return this.tech;
    }

    public RealClassroom(Integer id, String name, int size, Equipment tech) {
        super(id, name, size);
        this.tech = tech;
    }
}
