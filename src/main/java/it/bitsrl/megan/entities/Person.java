package it.bitsrl.megan.entities;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="person_role",
        discriminatorType = DiscriminatorType.STRING)
@Table(name="person")
public abstract class Person {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;

    @Enumerated
    private Gender gender;

    private LocalDate birthDate;

    private String birthPlace;
    private String fiscalCode;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    private String email;
    private String phone;

    @OneToMany(mappedBy="person")
    private Collection<Skill> skills;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Person(){}

    public Person(String firstName,String lastName,Gender gender){

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender =gender;

    }

    public Gender getGender(){
        return gender;
    }

    public boolean isMale(){
        return this.getGender() == Gender.MALE;
    }
}
