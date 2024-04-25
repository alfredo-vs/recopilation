package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.profesor.domain.repository.GetProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GetProfesorRepositoryImpl implements GetProfesorRepository {

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;




    @Override
    public Profesor getProfesorId(Long id) throws NotFoundException {

        ProfesorJpa profesorJpa = profesorJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Profesor no encontrado con el Id " + id));

        Profesor profesor = profesorMapperJpa.profesorJpaToProfesor(profesorJpa);

        profesor.setPersona(personaMapperJpa.personaJpaToPersona(profesorJpa.getPersonaJpa()));

        return profesor;
    }

    @Override
    public List<Profesor> getAllProfesor() {

        return profesorJpaRepository.findAll()
                .stream().map(profesorJpa ->
                {
                    Profesor profesor = profesorMapperJpa.profesorJpaToProfesor(profesorJpa);
                    profesor.setPersona(personaMapperJpa.personaJpaToPersona(profesorJpa.getPersonaJpa()));
                    return profesor;
                })
                .collect(Collectors.toList());
    }
}
