package com.aqua404.autodbbackend.dao;

import com.aqua404.autodbbackend.entity.Person;
import com.aqua404.autodb.backend.exception.DatabaseException;
import com.aqua404.autodbbackend.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.Optional;

import static com.aqua404.autodbbackend.util.Constants.personTable;

@Slf4j
@RequiredArgsConstructor
@Component
public class PersonDao {

    private final PersonRepository repository;

    public Optional<Person> findById(String id){
        try{
            return repository.findById(id);
        } catch (Exception ex){
            throw new DatabaseException(HttpStatus.INTERNAL_SERVER_ERROR, personTable);
        }

    }
}
