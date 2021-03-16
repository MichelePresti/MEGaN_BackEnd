package it.bitsrl.megan.controllers;

import it.bitsrl.megan.dtos.ClassroomDTO;
import it.bitsrl.megan.dtos.CourseEditionDTO;
import it.bitsrl.megan.dtos.ModuleDTO;
import it.bitsrl.megan.entities.*;
import it.bitsrl.megan.entities.Module;
import it.bitsrl.megan.services.abstractions.AbstractClassroomService;
import it.bitsrl.megan.services.abstractions.AbstractCourseEditionService;
import it.bitsrl.megan.services.abstractions.AbstractCourseService;
import it.bitsrl.megan.services.abstractions.AbstractPersonLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;


@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/course-editions")
public class CourseEditionController {

    @Autowired
    private AbstractCourseEditionService courseService;

    @Autowired
    private AbstractClassroomService classroomService;

    @Autowired
    private AbstractPersonLoginService personLoginService;

    @Autowired
    private AbstractCourseService courseBaseService;

    @GetMapping("/")
    public ResponseEntity<Collection<CourseEditionDTO>> getAllCourses() {
        Collection<CourseEditionDTO> result = this.courseService.getCourses().stream()
               .map(CourseEditionDTO::new)
                .collect(Collectors.toList());
         return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/recent")
    public ResponseEntity<Collection<CourseEditionDTO>> get4RecentCourses(){
        Collection<CourseEditionDTO> result = this.courseService.get4RecentCourses().stream()
                .map(CourseEditionDTO::new)
                .collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseEditionDTO> getCourseById(@PathVariable int id) {
        System.out.println(id);
        Optional<CourseEdition> result = this.courseService.getCourseById(id);
        if(result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(new CourseEditionDTO(result.get()), HttpStatus.OK);
    }

    @GetMapping("/title/{titleLike}")
    public ResponseEntity<Collection<CourseEditionDTO>> getCourseByTitleLike(@PathVariable String title){
        Collection<CourseEditionDTO> result = this.courseService.getCourseByTitleLike(title).stream()
                .map(CourseEditionDTO::new)
                .collect(Collectors.toList());

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/add-course-edition")
    public ResponseEntity<CourseEditionDTO> addCourse(@RequestBody CourseEditionDTO courseEditionDto){
        Classroom classroom;
        System.out.println(courseEditionDto);
        if(courseEditionDto.getClassroom().getClassroomType() == "VIRTUAL"){
            ClassroomDTO c = courseEditionDto.getClassroom();
            classroom = new VirtualClassroom(null, c.getName(), c.getSize(), c.getPlatform(), c.getLink(), c.getPassword());
        }
        classroom = this.classroomService.getClassroomById(courseEditionDto.getClassroom().getId()).get();
        Collection<Application> applications = new ArrayList<>();
        Collection<Enrollment> enrollments = new ArrayList<>();

        Collection<Module> modules = new LinkedList<>();
        for(ModuleDTO module: courseEditionDto.getModules()){
            Person teacher = this.personLoginService.findPersonByEmail(module.getTeacher().getEmail());
            List<Lesson> lessons = new LinkedList<>();
            Collection<Session> sessions = new LinkedList<>();
            //if(!(teacher instanceof Teacher)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            modules.add(new Module(null, module.getName(), module.getSubject(), teacher, module.getDurationHours(),lessons, null, sessions ));
        }

        Person editionManager = this.personLoginService.findPersonByEmail(courseEditionDto.getEditionManager().getEmail());
        //if(!(editionManager instanceof Employee)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        Course course = this.courseBaseService.getCourseById(courseEditionDto.getCourse().getId()).get();

        CourseEdition courseEdition = new CourseEdition(
                null,
                LocalDateTime.now(),
                classroom,
                applications,
                enrollments,
                modules,
                (Employee)editionManager,
                course,
                courseEditionDto.getCity(),
                courseEditionDto.getCourseEditionName(),
                courseEditionDto.getDuration()

        );
        CourseEdition result = this.courseService.addCourse(courseEdition);
        return new ResponseEntity<>(new CourseEditionDTO(result), HttpStatus.OK);
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
