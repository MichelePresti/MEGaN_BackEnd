package it.bitsrl.megan.repositories;

import it.bitsrl.megan.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {

    Person findTopByEmail(String email);
}
