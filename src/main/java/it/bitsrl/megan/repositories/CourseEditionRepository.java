package it.bitsrl.megan.repositories;

import it.bitsrl.megan.entities.Course;
import it.bitsrl.megan.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseEditionRepository extends JpaRepository<CourseEdition, Long> {

    Collection<CourseEdition> findByCourseNameLike(String title);
    Collection<CourseEdition> findTop4ByOrderByStartDateDesc();
}
