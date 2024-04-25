package com.example.block7crudvalidation.profesor.infracstructure.controller;

import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.profesor.application.usecases.EditProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.input.ProfesorInputDto;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profesor")
public class EditProfesorController {

    @Autowired
    EditProfesorUseCase editProfesorUseCase;

    @Autowired
    ProfesorMapperDto profesorMapperDto;


    @PutMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> editProfesor(@PathVariable Long id,
    @RequestBody ProfesorInputDto profesorInputDto) throws Exception{

        Profesor profesor = profesorMapperDto.inputDtoProfesorToProfesor(profesorInputDto);

        profesor = editProfesorUseCase.editProfesor(id, profesor);

        ProfesorOutputDto profesorOutputDto = profesorMapperDto.profesorToOutPutProfesor(profesor);

        return new ResponseEntity<>(profesorOutputDto, HttpStatus.OK);
    }

}
