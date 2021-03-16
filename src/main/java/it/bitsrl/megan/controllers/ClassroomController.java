package it.bitsrl.megan.controllers;

import it.bitsrl.megan.dtos.ClassroomDTO;
import it.bitsrl.megan.services.abstractions.AbstractClassroomService;
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
@RequestMapping("/api/classroom")
public class ClassroomController {

    @Autowired
    private AbstractClassroomService classroomService;

    @GetMapping(path="/")
    public ResponseEntity<Collection<ClassroomDTO>> getClassrooms(){
        Collection<ClassroomDTO> result = this.classroomService.getClassrooms().stream().map(ClassroomDTO::new).collect(Collectors.toList());
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
