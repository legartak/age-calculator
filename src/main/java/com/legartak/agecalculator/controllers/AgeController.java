package com.legartak.agecalculator.controllers;

import com.legartak.agecalculator.dto.Person;
import com.legartak.agecalculator.services.PersonService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AgeController {

    private final PersonService personService;

    public AgeController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("user/{userId}")
    public Person calculateAge(@PathVariable int userId) {
        return personService.findById(userId);
    }
}
