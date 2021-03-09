package it.bitsrl.megan.entities;

import javax.persistence.*;

@Entity
@DiscriminatorValue("REAL")
public class RealClassroom extends Classroom{


    @Enumerated(EnumType.STRING)
    private Equipment tech;

    @Override
    public boolean hasComputer() {
        return true;
    }

    @Override
    public boolean hasProjectors() {
        return true;
    }
    
}
