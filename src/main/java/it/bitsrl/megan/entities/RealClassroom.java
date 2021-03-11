package it.bitsrl.megan.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("REAL")
public class RealClassroom extends Classroom{


    public RealClassroom(){}
    @Enumerated(EnumType.STRING)
    private Equipment tech;


    public RealClassroom(long id){
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
