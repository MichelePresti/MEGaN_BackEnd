package it.bitsrl.megan.services.implementations;

import it.bitsrl.megan.entities.CourseEdition;
import it.bitsrl.megan.repositories.CourseEditionRepository;
import it.bitsrl.megan.services.abstractions.AbstractCourseEditionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class CourseEditionService implements AbstractCourseEditionService {

    @Autowired
    private CourseEditionRepository courseRepo;

    @Override
    public Collection<CourseEdition> getCourses() {

        return (Collection<CourseEdition>) this.courseRepo.findAll();
    }

    @Override
    public Collection<CourseEdition> getCourseByTitleLike(String title) {
        return this.courseRepo.findByCourseTitleLike(title); // title = "java%"
    }

    @Override
    public CourseEdition getCourseById(long id) {
        return this.courseRepo.findByCourseId(id);
    }

    @Override
    public CourseEdition addCourse(CourseEdition course) {
        return this.courseRepo.save(course);
    }

    @Override
    public Boolean deleteCourseById(long id) {
        Optional<CourseEdition> courseDelete = this.courseRepo.findById(id);
        if (courseDelete.isEmpty()) {
            return false;
        }
        this.courseRepo.deleteById(id);
        return true;
    }

    @Override
    public CourseEdition updateCourse(CourseEdition course) {
        Optional<CourseEdition> courseUpdate = this.courseRepo.findById(course.getId());
        courseUpdate.ifPresent(value -> course.setId(value.getId()));
        return this.courseRepo.save(course);
    }


}
