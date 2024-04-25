package com.example.block7crudvalidation.persona.infrastructure.controller;

import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.persona.application.usecases.CreatePersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.infrastructure.controller.dto.input.PersonaInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persona")
public class CreatePersonaController {

    @Autowired
    CreatePersonaUseCase createPersonaUseCase;

    @Autowired
    PersonaMapperDto personaMapperDto;


    @PostMapping
    public ResponseEntity<PersonaOutputDto> createPersona (@RequestBody PersonaInputDto personaInputDto) throws Exception {

        //Instanciamos una persona
        Persona persona = personaMapperDto.personaInputDtoToPersona(personaInputDto);

        //Con ella hacemos uso de createPersonaUseCase para guardarla en el repositorio
        persona = createPersonaUseCase.create(persona);

        //La convertimos a un Output Dto
        PersonaOutputDto personaOutputDto= personaMapperDto.personaToPersonaOutputDto(persona);

        return new ResponseEntity<>(personaOutputDto, HttpStatus.CREATED);
    }





}
