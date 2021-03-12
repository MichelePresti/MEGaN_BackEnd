package it.bitsrl.megan.services.abstractions;

import it.bitsrl.megan.entities.Person;

import java.util.Collection;

public interface AbstractPersonLoginService {

    Person addPerson(Person person);
    Person findPersonByEmail(String email);
    Collection<Person> getAllUsers();
}
