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
    @OneToOne(cascade = CascadeType.PERSIST)
    private Address address;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;
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

    public Person(String firstName, String lastName, String email, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.address = null;
        this.birthPlace = "";
        this.birthDate = null;
        this.phone = "";
        this.gender = Gender.MALE;

    }
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public String getFiscalCode() {
        return fiscalCode;
    }

    public void setFiscalCode(String fiscalCode) {
        this.fiscalCode = fiscalCode;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Skill> getSkills() {
        return skills;
    }

    public void setSkills(Collection<Skill> skills) {
        this.skills = skills;
    }
}
