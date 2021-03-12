package it.bitsrl.megan.entities;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends Person {

    @OneToMany(mappedBy="student")
    private Collection<Enrollment> enrollments;

    @OneToMany(mappedBy="student")
    private Collection<Presence> presences;

    @OneToMany(mappedBy="student")
    private Collection<Application> applications;


    public Student(){}
    public Student(String name,String surname,Gender gender){
        super(name,surname,gender);
    }


    public Student(String name, String surname, String email,String password){
        super(name, surname, email, password);
    }


}
