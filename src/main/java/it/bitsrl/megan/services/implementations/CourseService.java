package it.bitsrl.megan.services.implementations;

import it.bitsrl.megan.entities.Course;
import it.bitsrl.megan.repositories.CourseRepository;
import it.bitsrl.megan.services.abstractions.AbstractCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements AbstractCourseService {

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public Collection<Course> getCourses() {
        return this.courseRepo.findAll();
    }
    public Optional<Course> getCourseById(int id){ return this.courseRepo.findById(id); }
}
