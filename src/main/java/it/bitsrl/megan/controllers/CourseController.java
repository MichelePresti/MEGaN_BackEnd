package it.bitsrl.megan.controllers;

import it.bitsrl.megan.dtos.CourseDTO;
import it.bitsrl.megan.services.abstractions.AbstractCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private AbstractCourseService courseService;

    @GetMapping(path="/")
    public ResponseEntity<Collection<CourseDTO>> getCourses(){
        Collection<CourseDTO> result = this.courseService.getCourses().stream().map(CourseDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
