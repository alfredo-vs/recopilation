package com.example.block7crudvalidation.persona.infrastructure.controller;

import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.persona.application.usecases.EditPersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.infrastructure.controller.dto.input.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/persona")
public class EditPersonaController {

    @Autowired
    EditPersonaUseCase editPersonaUseCase;

    @Autowired
    PersonaMapperDto personaMapperDto;



    @PutMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> editPersona(@PathVariable Long id, @RequestBody PersonaInputDto personaInputDto) throws Exception {

        Persona persona = personaMapperDto.personaInputDtoToPersona(personaInputDto);

        persona = editPersonaUseCase.edit(id, persona);

        PersonaOutputDto personaOutputDto = personaMapperDto.personaToPersonaOutputDto(persona);

        return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
    }
}
