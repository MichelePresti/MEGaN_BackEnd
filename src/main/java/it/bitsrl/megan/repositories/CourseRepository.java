package it.bitsrl.megan.repositories;

import it.bitsrl.megan.entities.CourseEdition;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface CourseRepository extends JpaRepository<CourseEdition, Long> {

    Collection<CourseEdition> findByCourseTitleLike(String title);
    CourseEdition findByCourseId(long id);
}
