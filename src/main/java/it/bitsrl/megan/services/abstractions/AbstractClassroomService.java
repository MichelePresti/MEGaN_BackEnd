package it.bitsrl.megan.services.abstractions;

import it.bitsrl.megan.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface AbstractClassroomService{

    public Collection<Classroom> getClassrooms();

    Optional<Classroom> getClassroomById(long id);
}
