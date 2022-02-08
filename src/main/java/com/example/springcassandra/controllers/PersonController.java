package com.example.springcassandra.controllers;

import com.example.springcassandra.model.Person;
import com.example.springcassandra.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/person")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {

    private final PersonRepository personRepository;

    //    @PostConstruct
    public void savePerson() {
        List<Person> people = Arrays.asList(
                new Person(100, "Giash Uddin", "Dhaka, Bangladesh", 25),
                new Person(101, "Minhaz Nihal", "Comilla, Bangladesh", 26),
                new Person(102, "Sajib Hossen", "Manikganj, Bangladesh", 28),
                new Person(103, "Biplob Hossen", "Kushtia, Bangladesh", 23),
                new Person(104, "Sobuj Ahmed", "Meherpur, Bangladesh", 27),
                new Person(105, "Moin Rana", "Chattagram, Bangladesh", 27)
        );

        personRepository.saveAll(people);
    }

    @GetMapping
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/age/{age}")
    public List<Person> getAllPersonByAge(@PathVariable int age) {
        return personRepository.findAllByAgeGreaterThan(age);
    }
}
