package com.aqua404.autodbbackend.service;

import com.aqua404.autodbbackend.dao.PersonDao;
import com.aqua404.autodbbackend.entity.Person;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    @Override
    public Optional<Person> getPerson(String id) {
        log.debug("PersonServiceImpl - getPerson() - method");
        Optional<Person> otpPerson = personDao.findById(id);
        if (otpPerson.isEmpty()){
            return Optional.empty();
        }

        return personDao.findById(id);
    }

    public String generateQuery(){


        return "";
    }
}
