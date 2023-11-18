package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.entity.Person;

import java.util.Optional;

public interface PersonService {
    Optional<Person> getPerson(String id);
}
