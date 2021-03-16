package it.bitsrl.megan.services.implementations;

import it.bitsrl.megan.entities.Person;
import it.bitsrl.megan.repositories.PersonRepository;
import it.bitsrl.megan.services.abstractions.AbstractPersonLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PersonLoginService implements AbstractPersonLoginService {

    @Autowired
    private PersonRepository personRepo;

    public Person addPerson(Person person){
        return this.personRepo.save(person);
    }

    @Override
    public Person findPersonByEmail(String email) {
        return this.personRepo.findTopByEmail(email);
    }

    @Override
    public Collection<Person> getAllUsers() {
        return this.personRepo.findAll();
    }


}
