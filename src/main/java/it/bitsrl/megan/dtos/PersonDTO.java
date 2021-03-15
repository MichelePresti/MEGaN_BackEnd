package it.bitsrl.megan.dtos;

import it.bitsrl.megan.entities.*;


public class PersonDTO {

    private String firstName;
    private String lastName;
    private Gender gender;

    private String personType;
    private String birthDate;

    private String birthPlace;
    private String fiscalCode;
    private String address;
    private String email;
    private String password;
    private String phone;

    public PersonDTO(){ }

    public PersonDTO(Person person) {
       this.firstName = person.getFirstName();
       this.lastName = person.getLastName();
       this.gender = person.getGender();
       this.birthDate = null;
       this.birthPlace = person.getBirthPlace();
       this.fiscalCode = person.getFiscalCode();
       this.address = null;
       this.email = person.getEmail();
       this.password = person.getPassword();
       this.phone = person.getPhone();
       if(person instanceof Student) this.personType = "STUDENT";
       else if(person instanceof Employee) this.personType = "EMPLOYEE";
       else this.personType = "TEACHER";
    }

    public Person toPersonLogin(PersonDTO personDto) {

        System.out.println(personDto);
        if (personDto.personType.equals("STUDENT")) {
            return new Student(personDto.firstName, personDto.lastName, personDto.email, personDto.password);
        } else if (personDto.personType.equals("EMPLOYEE")) {
            return new Employee(personDto.firstName, personDto.lastName, personDto.email, personDto.password);
        }
        return new Teacher(personDto.firstName, personDto.lastName, personDto.email, personDto.password);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public boolean checkPassword(){
        return this.password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
    }
}
