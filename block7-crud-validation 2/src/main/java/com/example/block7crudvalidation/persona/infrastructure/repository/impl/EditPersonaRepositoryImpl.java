package com.example.block7crudvalidation.persona.infrastructure.repository.impl;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.EditPersonaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class EditPersonaRepositoryImpl implements EditPersonaRepository {


    @Autowired
    PersonaJpaRepository personaJpaRepository;

    @Autowired
    PersonaMapperJpa personaMapperJpa;




    @Override
    public Persona editPersona(Long id, Persona persona) throws NotFoundException {

        PersonaJpa personaJpa = personaJpaRepository.findById(id).
                orElseThrow(() -> new NotFoundException("Persona no encontrada con ID: " + id));


        if (Objects.nonNull(persona.getUsuario())){
            personaJpa.setUsuario(persona.getUsuario());
        }
        if (Objects.nonNull(persona.getPassword())) {
            personaJpa.setPassword(persona.getPassword());
        }
        if (Objects.nonNull(persona.getName())) {
            personaJpa.setName(persona.getName());
        }
        if (Objects.nonNull(persona.getSurname())){
            personaJpa.setSurname(persona.getSurname());
        }
        if (Objects.nonNull(persona.getCompanyEmail())) {
            personaJpa.setCompanyEmail(persona.getCompanyEmail());
        }
        if (Objects.nonNull(persona.getPersonalEmail())) {
            personaJpa.setPersonalEmail(persona.getPersonalEmail());
        }
        if (Objects.nonNull(persona.getCity())){
            personaJpa.setCity(persona.getCity());
        }
        if (Objects.nonNull(persona.getActive())) {
            personaJpa.setActive(persona.getActive());
        }
        if (Objects.nonNull(persona.getCreatedDate())) {
            personaJpa.setCreatedDate(persona.getCreatedDate());
        }
        if (Objects.nonNull(persona.getImageUrl())) {
            personaJpa.setImageUrl(persona.getImageUrl());
        }
        if (Objects.nonNull(persona.getTerminationDate())) {
            personaJpa.setTerminationDate(persona.getTerminationDate());
        }

        personaJpa = personaJpaRepository.save(personaJpa);

        Persona personaEdited = personaMapperJpa.personaJpaToPersona(personaJpa);

        return personaEdited;
    }
}
