package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.profesor.domain.repository.DeleteProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteProfesorRepositoryImpl implements DeleteProfesorRepository {

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;


    @Override
    public Profesor deleteProfesor(Long id) throws NotFoundException {

        ProfesorJpa profesorJpa = profesorJpaRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("Profesor no encontrado con Id: "+ id));

        Profesor profesor = profesorMapperJpa.profesorJpaToProfesor(profesorJpa);

        profesor.setPersona(personaMapperJpa.personaJpaToPersona(profesorJpa.getPersonaJpa()));

        profesorJpaRepository.delete(profesorJpa);

        return profesor;
    }
}
