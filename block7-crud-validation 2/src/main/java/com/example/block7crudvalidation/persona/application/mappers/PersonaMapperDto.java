package com.example.block7crudvalidation.persona.application.mappers;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.infrastructure.controller.dto.input.PersonaInputDto;
import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonaMapperDto {



    @Mapping(source = "usuario", target = "usuario")
    @Mapping (source = "password", target = "password")
    @Mapping (source = "name", target = "name")

    @Mapping(source = "surname", target = "surname")
    @Mapping (source = "companyEmail", target = "companyEmail")
    @Mapping (source = "personalEmail", target = "personalEmail")

    @Mapping(source = "city", target = "city")
    @Mapping (source = "active", target = "active")
    @Mapping (source = "createdDate", target = "createdDate")

    @Mapping (source = "imageUrl", target = "imageUrl")
    @Mapping (source = "terminationDate", target = "terminationDate")
    Persona personaInputDtoToPersona(PersonaInputDto personaInputDto);


    PersonaOutputDto personaToPersonaOutputDto(Persona persona);
}
