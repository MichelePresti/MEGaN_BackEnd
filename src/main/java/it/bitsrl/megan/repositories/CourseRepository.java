package it.bitsrl.megan.repositories;

import it.bitsrl.megan.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
}
