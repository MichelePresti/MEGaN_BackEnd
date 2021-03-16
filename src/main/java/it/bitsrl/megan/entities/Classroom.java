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
    private Integer id;
    private String name;
    private int size;


    public Classroom(Integer id, String name, int size) {
        this.id = id;
        this.name = name;
        this.size = size;
    }

    public Classroom(){}
    public Classroom(Integer id){
        this.id = id;
    }
    public abstract boolean hasComputer();
    public abstract boolean hasProjectors();
    public long getId() {
        return id;
    }
    public void setId(Integer id) {
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
}
