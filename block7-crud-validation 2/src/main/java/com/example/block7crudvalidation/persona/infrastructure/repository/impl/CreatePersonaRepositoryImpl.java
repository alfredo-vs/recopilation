package com.example.block7crudvalidation.persona.infrastructure.repository.impl;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.CreatePersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class CreatePersonaRepositoryImpl implements CreatePersonaRepository {


    @Autowired
    PersonaJpaRepository personaJpaRepository;

    @Autowired
    PersonaMapperJpa personaMapperJpa;


    @Override
    public Persona createPersona(Persona persona) {

        PersonaJpa personaJpa = personaMapperJpa.personaToPersonaJpa(persona);

        personaJpa = personaJpaRepository.save(personaJpa);

        Persona personaSaved = personaMapperJpa.personaJpaToPersona(personaJpa);

        return personaSaved;
    }
}
