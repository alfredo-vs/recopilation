package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.profesor.domain.repository.CreateProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateProfesorRepositoryImpl implements CreateProfesorRepository {

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    PersonaJpaRepository personaJpaRepository;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;



    @Override
    public Profesor createProfesor(Profesor profesor) throws NotFoundException {

        ProfesorJpa profesorJpa = profesorMapperJpa.profesorToProfesorJpa(profesor);

        PersonaJpa personaJpa = personaJpaRepository.findById(profesor.getPersona().getIdPersona()).orElseThrow(
                () -> new NotFoundException("Persona no encontrada"));


        profesorJpa.setPersonaJpa(personaJpa);

        profesorJpa = profesorJpaRepository.save(profesorJpa);

        Profesor profesorDevuelto = profesorMapperJpa.profesorJpaToProfesor(profesorJpa);

        profesorDevuelto.setPersona(personaMapperJpa.personaJpaToPersona(profesorJpa.getPersonaJpa()));

        return profesorDevuelto;
    }
}
