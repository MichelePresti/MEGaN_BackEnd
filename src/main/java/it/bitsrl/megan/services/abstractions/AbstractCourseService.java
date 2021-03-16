package it.bitsrl.megan.services.abstractions;

import it.bitsrl.megan.entities.Course;

import java.util.Collection;
import java.util.Optional;

public interface AbstractCourseService {

    public Collection<Course> getCourses();
    public Optional<Course> getCourseById(int id);
}
