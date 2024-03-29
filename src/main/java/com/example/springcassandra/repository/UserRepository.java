package com.example.springcassandra.repository;

import com.example.springcassandra.model.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {
    @AllowFiltering
    List<User> findByAgeGreaterThan(int age);
}
