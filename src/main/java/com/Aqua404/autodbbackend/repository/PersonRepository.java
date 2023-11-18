package com.aqua404.autodbbackend.repository;

import com.aqua404.autodbbackend.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
    @Override
    Optional<Person> findById(String id);
}
