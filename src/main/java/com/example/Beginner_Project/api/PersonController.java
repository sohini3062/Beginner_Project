package com.example.Beginner_Project.api;

import com.example.Beginner_Project.model.Person;
import com.example.Beginner_Project.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
// this exposes endpoints for clients to consume
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired // for springboot to inject
    public PersonController(PersonService personService){
        this.personService=personService;
    }

    // to tell SPRING use Annotation
    @PostMapping
    public void addPerson(@RequestBody Person person) //POST Request
    {
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeople(){
        return personService.getAllPeople();
    }
    @GetMapping(path="{id}")
    public Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }



}

