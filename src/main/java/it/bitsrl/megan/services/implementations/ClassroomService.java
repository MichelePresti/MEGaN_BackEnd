package it.bitsrl.megan.services.implementations;

import it.bitsrl.megan.entities.Classroom;
import it.bitsrl.megan.repositories.ClassroomRepository;
import it.bitsrl.megan.services.abstractions.AbstractClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ClassroomService implements AbstractClassroomService {

    @Autowired
    private ClassroomRepository classroomRepo;


    @Override
    public Collection<Classroom> getClassrooms() {
        return this.classroomRepo.findAll();
    }

    @Override
    public Optional<Classroom> getClassroomById(long id) {
        return this.classroomRepo.findById((int)id);
    }
}
