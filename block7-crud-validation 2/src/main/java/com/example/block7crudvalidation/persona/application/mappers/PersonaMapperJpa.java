package com.example.block7crudvalidation.persona.application.mappers;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonaMapperJpa {

    PersonaJpa personaToPersonaJpa(Persona persona);

    @InheritInverseConfiguration
    Persona personaJpaToPersona(PersonaJpa personaJpa);
}
