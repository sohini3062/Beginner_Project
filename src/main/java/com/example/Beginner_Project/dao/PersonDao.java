package com.example.Beginner_Project.dao;

import com.example.Beginner_Project.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {

    //insert a person into database
    // return 0 or 1 depending on success
    int insertPerson(UUID id, Person person); // inserts person with an id
    // this method will add a person who has no id and gives a random id to the person
    default int insertPerson(Person person){
        UUID id = UUID.randomUUID();
        return insertPerson(id,person);
    }
    List<Person> selectAllPeople();

    int deletePersonById(UUID id);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID id);
}
