package com.example.Beginner_Project.dao;

import com.example.Beginner_Project.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
// repository makes it obvious that this class is repo
@Repository("fakeDao") // helps to make multiple implementations
public class FakePersonDataAccessService implements PersonDao {

    private static List<Person> DB=new ArrayList<>();

    @Override
    public int insertPerson(UUID id,Person person)
    {
        DB.add(new Person(id,person.getName()));
        return 1;
    }
    @Override
    public List<Person> selectAllPeople(){
        return DB;
    }

    @Override
    public int deletePersonById(UUID id) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream()
                .filter(person->person.getId().equals(id)).findFirst();
    }
}
