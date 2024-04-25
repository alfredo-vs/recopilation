package com.example.block7crudvalidation.persona.infrastructure.controller;

import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import com.example.block7crudvalidation.z_shared.feign.MyFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/persona")
public class GetPersonaController {


    @Autowired
    GetPersonaUseCase getPersonaUseCase;

    @Autowired
    PersonaMapperDto personaMapperDto;

    @Autowired
    MyFeign myFeign;


    @GetMapping("/{id}")
    public ResponseEntity<PersonaOutputDto> getPersonaId(@PathVariable Long id) throws NotFoundException {
        Persona persona = getPersonaUseCase.getById(id);
        PersonaOutputDto personaOutputDto = personaMapperDto.personaToPersonaOutputDto(persona);
        return new ResponseEntity<>(personaOutputDto, HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<PersonaOutputDto>> getPersonaAll(){

        List<Persona> personas = getPersonaUseCase.getAll();

        List<PersonaOutputDto> personaOutputDtoList = personas
                .stream().map(persona -> personaMapperDto.personaToPersonaOutputDto(persona))
                .collect(Collectors.toList());

        return new ResponseEntity<>(personaOutputDtoList, HttpStatus.OK);
    }

    @GetMapping("/usuario/{nombreUsuario}")
    public ResponseEntity<List<PersonaOutputDto>>getPersonaUsuario(@PathVariable String nombreUsuario){
        List<Persona> personas = getPersonaUseCase.getPersonaUsuario(nombreUsuario);

        List<PersonaOutputDto> personaOutputDtoList = personas
                .stream().map(persona -> personaMapperDto.personaToPersonaOutputDto(persona))
                .collect(Collectors.toList());


        return new ResponseEntity<>(personaOutputDtoList, HttpStatus.OK);
    }


    @GetMapping("/profesor/{id}")
    ResponseEntity<ProfesorOutputDto> getProfesorFeignId(@PathVariable Long id) throws NotFoundException{
        return myFeign.getProfesorId(id);
    }

}
