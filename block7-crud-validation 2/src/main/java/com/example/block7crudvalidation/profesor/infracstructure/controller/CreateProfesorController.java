package com.example.block7crudvalidation.profesor.infracstructure.controller;


import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.profesor.application.usecases.CreateProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.input.ProfesorInputDto;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class CreateProfesorController {

    @Autowired
    CreateProfesorUseCase createProfesorUseCase;

    @Autowired
    ProfesorMapperDto profesorMapperDto;


    @PostMapping
    public ResponseEntity<ProfesorOutputDto> createProfesor (@RequestBody ProfesorInputDto profesorInputDto) throws Exception{

        Profesor profesor = createProfesorUseCase.createProfesor(profesorInputDto);

        ProfesorOutputDto profesorOutputDto = profesorMapperDto.profesorToOutPutProfesor(profesor);

        return new ResponseEntity<>(profesorOutputDto, HttpStatus.CREATED);
    }


}
