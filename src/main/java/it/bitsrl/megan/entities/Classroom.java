package it.bitsrl.megan.entities;


import javax.persistence.*;

@Entity
@Table(name="classroom")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="classroom_type",
                     discriminatorType = DiscriminatorType.STRING)
public abstract class Classroom {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String name;
    private String title;
    private int size;

    public abstract boolean hasComputer();

    public abstract boolean hasProjectors();

}
