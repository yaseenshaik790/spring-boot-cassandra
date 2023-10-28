package com.sky.cassandra.repository;

import com.sky.cassandra.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.List;

public interface UserRepository extends CassandraRepository<User, Integer> {
    List<User> findByAgeLessThan(int age);

    List<User> findByAddress(String address);
}
