package it.bitsrl.megan.controllers;


import it.bitsrl.megan.dtos.PersonDTO;
import it.bitsrl.megan.entities.Person;
import it.bitsrl.megan.services.abstractions.AbstractPersonLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/api/")
public class PersonLoginController {

    @Autowired
    private AbstractPersonLoginService loginService;

    @PostMapping(path="/sign-up/")
    public ResponseEntity<Person> addPerson(@RequestBody PersonDTO personDto){
        boolean isAlreadyRegistered = this.loginService.findPersonByEmail(personDto.getEmail()) != null;
        if(isAlreadyRegistered){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(this.loginService.addPerson(personDto.toPersonLogin(personDto)), HttpStatus.CREATED);
    }

    @GetMapping(path="/students")
    public ResponseEntity<Collection<PersonDTO>> getPerson(){
        System.out.println("è arrivato");
        Collection<PersonDTO> result = this.loginService.getAllUsers().stream()
                .map(PersonDTO::new)
                .collect(Collectors.toList());

        System.out.println(result);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(path="/login")
    public ResponseEntity<PersonDTO> checkLogin(@RequestBody PersonDTO userDto){
        Person user = this.loginService.findPersonByEmail(userDto.getEmail());
        if(user == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(!user.getPassword().equals(userDto.getPassword())) {
            return new ResponseEntity<> (HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        }


        return new ResponseEntity<>(new PersonDTO(user), HttpStatus.OK);
    }

}
