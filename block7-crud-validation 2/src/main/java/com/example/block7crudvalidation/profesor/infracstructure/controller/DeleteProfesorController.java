package com.example.block7crudvalidation.profesor.infracstructure.controller;


import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.profesor.application.usecases.DeleteProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profesor")
public class DeleteProfesorController {

    @Autowired
    DeleteProfesorUseCase deleteProfesorUseCase;

    @Autowired
    ProfesorMapperDto profesorMapperDto;

    @DeleteMapping("/{id}")
    public ResponseEntity<ProfesorOutputDto> deleteProfesor(@PathVariable Long id) throws NotFoundException{

        Profesor profesor = deleteProfesorUseCase.deleteProfesor(id);

        ProfesorOutputDto profesorOutputDto = profesorMapperDto.profesorToOutPutProfesor(profesor);

        return new ResponseEntity<>(profesorOutputDto, HttpStatus.OK);
    }

}
