package com.legartak.agecalculator.persistence.repositories;

import com.legartak.agecalculator.persistence.domain.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {
}
