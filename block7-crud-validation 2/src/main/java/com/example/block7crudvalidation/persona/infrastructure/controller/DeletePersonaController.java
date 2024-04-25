package com.example.block7crudvalidation.persona.infrastructure.controller;

import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.persona.application.usecases.DeletePersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class DeletePersonaController {

    @Autowired
    DeletePersonaUseCase deletePersonaUseCase;

    @Autowired
    PersonaMapperDto personaMapperDto;


    @DeleteMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> deletePersona(@PathVariable Long id) throws NotFoundException {

        Persona persona = deletePersonaUseCase.delete(id);

        PersonaOutputDto personaOutputDto = personaMapperDto.personaToPersonaOutputDto(persona);

        return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);

    }


}
