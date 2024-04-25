package com.example.block7crudvalidation.persona.infrastructure.repository.impl;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.DeletePersonaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class DeletePersonaRepositoryImpl implements DeletePersonaRepository {

    @Autowired
    PersonaJpaRepository personaJpaRepository;


    @Autowired
    PersonaMapperJpa personaMapperJpa;



    @Override
    public Persona deletePersona(Long id) throws NotFoundException {

        PersonaJpa personaJpa = personaJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Persona no encontrada con ID: " + id));

//        PersonaJpa personaJpa = personaJpaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
//                HttpStatus.NOT_FOUND, "Persona no encontrada"));


        Persona toReturnPersona = personaMapperJpa.personaJpaToPersona(personaJpa);
        personaJpaRepository.delete(personaJpa);

        return toReturnPersona;
    }
}
