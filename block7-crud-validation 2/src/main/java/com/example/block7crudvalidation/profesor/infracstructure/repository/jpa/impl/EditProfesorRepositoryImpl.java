package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.domain.repository.EditProfesorRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class EditProfesorRepositoryImpl implements EditProfesorRepository {

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;



    @Override
    public Profesor editProfesor(Long id, Profesor profesor) throws NotFoundException {


        ProfesorJpa profesorJpa = profesorJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profesor no encontrado con el Id " + id));


        if(Objects.nonNull(profesor.getBranch()))
        profesorJpa.setBranch(profesor.getBranch());

        if(Objects.nonNull(profesor.getComents()))
        profesorJpa.setComents(profesor.getComents());


        profesorJpaRepository.save(profesorJpa);

        profesor = profesorMapperJpa.profesorJpaToProfesor(profesorJpa);

        profesor.setPersona(personaMapperJpa.personaJpaToPersona(profesorJpa.getPersonaJpa()));

        return profesor;
    }
}
