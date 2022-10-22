package com.legartak.agecalculator.services;

import com.legartak.agecalculator.dto.Person;
import com.legartak.agecalculator.persistence.domain.PersonEntity;
import com.legartak.agecalculator.persistence.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Person findById(int id) {
        Optional<PersonEntity> human = personRepository.findById(id);
        if (human.isPresent()) {
            int age = Period.between(human.get().getBirthday(), LocalDate.now()).getYears();
            return new Person(human.get().getName(), human.get().getSurname(), age);
        }
        return null;
    }

}
