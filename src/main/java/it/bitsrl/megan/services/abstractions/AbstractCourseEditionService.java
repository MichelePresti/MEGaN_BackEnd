package it.bitsrl.megan.services.abstractions;

import it.bitsrl.megan.entities.Course;
import it.bitsrl.megan.entities.CourseEdition;

import java.util.Collection;

public interface AbstractCourseEditionService {


    Collection<CourseEdition> getCourses();
    Collection<CourseEdition> getCourseByTitleLike(String title);
    Collection<CourseEdition> get4RecentCourses();
    CourseEdition getCourseById(long id);
    CourseEdition addCourse(CourseEdition course);
    Boolean deleteCourseById(long id);
    CourseEdition updateCourse(CourseEdition course);


}
