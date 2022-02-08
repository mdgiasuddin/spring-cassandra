package com.example.springcassandra.repository;

import com.example.springcassandra.model.Person;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface PersonRepository extends CassandraRepository<Person, Integer> {

    @AllowFiltering
    List<Person> findAllByAgeGreaterThan(int age);
}
