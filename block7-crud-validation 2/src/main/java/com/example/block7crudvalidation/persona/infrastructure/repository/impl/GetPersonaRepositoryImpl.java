package com.example.block7crudvalidation.persona.infrastructure.repository.impl;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.GetPersonaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class GetPersonaRepositoryImpl implements GetPersonaRepository {

    @Autowired
    PersonaJpaRepository personaJpaRepository;

    @Autowired
    PersonaMapperJpa personaMapperJpa;




    @Override
    public Persona getPersonaId(Long id) throws NotFoundException {

        PersonaJpa personaJpa = personaJpaRepository.findById(id).orElseThrow(
                ()-> new NotFoundException("Persona no encontrada con ID: " + id));

        Persona persona = personaMapperJpa.personaJpaToPersona(personaJpa);

        return persona;
    }

    @Override
    public List<Persona> getPersonaAll() {

        List<PersonaJpa> personaJpas = personaJpaRepository.findAll();

        List<Persona> personas = personaJpas
                .stream().map(p -> personaMapperJpa.personaJpaToPersona(p))
                .collect(Collectors.toList());


        return personas;
    }

    @Override
    public List<Persona> getPersonaUsuario(String usuario) {

        List<PersonaJpa> personaJpas = personaJpaRepository.findAll();

        List<Persona> personas = personaJpas
                .stream().map(p -> personaMapperJpa.personaJpaToPersona(p))
                .filter(p -> Objects.equals(p.getUsuario(), usuario))
                .collect(Collectors.toList());

        return personas;
    }
}
