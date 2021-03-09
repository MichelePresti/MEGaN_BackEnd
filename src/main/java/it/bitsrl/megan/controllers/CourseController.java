package it.bitsrl.megan.controllers;

import it.bitsrl.megan.dtos.CourseEditionDTO;
import it.bitsrl.megan.entities.CourseEdition;
import it.bitsrl.megan.services.abstractions.AbstractCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.stream.Collectors;


@CrossOrigin
@RestController
@RequestMapping("/api/course")
public class CourseController {

    @Autowired
    private AbstractCourseService courseService;

    @GetMapping("/")
    public ResponseEntity<Collection<CourseEditionDTO>> getAllCourses() {
        Collection<CourseEditionDTO> result = this.courseService.getCourses().stream()
                .map(CourseEditionDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id]")
    public ResponseEntity<CourseEditionDTO> getCourseById(@PathVariable int id) {
        CourseEdition result = this.courseService.getCourseById(id);
        if(result == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CourseEditionDTO(result), HttpStatus.OK);
    }

    @GetMapping("/{titleLike}")
    public ResponseEntity<Collection<CourseEditionDTO>> getCourseByTitleLike(@PathVariable String title){
        Collection<CourseEditionDTO> result = this.courseService.getCourseByTitleLike(title).stream()
                .map(CourseEditionDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/add-course")
    public ResponseEntity<CourseEditionDTO> addCourse(@RequestBody CourseEdition course){
        CourseEdition status = this.courseService.addCourse(course);
        if (status == null){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new CourseEditionDTO(course), HttpStatus.OK);
    }

    @DeleteMapping(path="/delete-course/{id}")
    public ResponseEntity<String> deleteCourseById(@PathVariable int id){
        Boolean status = this.courseService.deleteCourseById(id);
        if(status){
            return new ResponseEntity<>("Corso eliminato correttamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Impossibile eliminare il corso, perchè non presente nel database", HttpStatus.BAD_REQUEST);
    }



}
