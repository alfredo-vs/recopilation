package com.example.block7crudvalidation.profesor.infracstructure.controller;

import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.profesor.application.usecases.GetProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
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
@RequestMapping("/profesor")
public class GetProfesorController {

    @Autowired
    GetPersonaUseCase getPersonaUseCase;

    @Autowired
    GetProfesorUseCase getProfesorUseCase;

    @Autowired
    ProfesorMapperDto profesorMapperDto;




    @GetMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorId(@PathVariable Long id) throws NotFoundException{
        Profesor profesor = getProfesorUseCase.getById(id);

        ProfesorOutputDto profesorOutputDto = profesorMapperDto.profesorToOutPutProfesor(profesor);

        return new ResponseEntity<>(profesorOutputDto, HttpStatus.OK);
    }




    @GetMapping
    public ResponseEntity<List<ProfesorOutputDto>> getAllProfesors(){

        List<ProfesorOutputDto> profesorOutputDtos = getProfesorUseCase.getAll()
                .stream()
                .map(p ->
                {
                    ProfesorOutputDto outputDto = profesorMapperDto.profesorToOutPutProfesor(p);
                    return outputDto;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(profesorOutputDtos, HttpStatus.OK);
    }

}
















