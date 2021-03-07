package it.bitsrl.megan.entities;


import javax.persistence.*;

@Entity
@DiscriminatorValue("REAL")
@Table(name="real_classroom")
public class RealClassroom extends Classroom{


    @Enumerated(EnumType.STRING)
    private Equipment tech;

    @Override
    public boolean hasComputer() {
        return tech == Equipment.PC || tech == Equipment.FULL;
    }

    @Override
    public boolean hasProjectors() {
        return tech == Equipment.PROJECTOR || tech == Equipment.FULL;
    }

}
