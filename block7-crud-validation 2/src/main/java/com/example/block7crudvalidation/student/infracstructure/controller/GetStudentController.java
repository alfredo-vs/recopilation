package com.example.block7crudvalidation.student.infracstructure.controller;


import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.application.usecases.GetProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperDto;
import com.example.block7crudvalidation.student.application.usecases.GetStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.output.StudentOutputDto;
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
@RequestMapping("/student")
public class GetStudentController {

    @Autowired
    GetStudentUseCase getStudentUseCase;

    @Autowired
    StudentMapperDto studentMapperDto;


    @GetMapping("/{id}")
    public ResponseEntity<StudentOutputDto> getStudentId(@PathVariable Long id) throws NotFoundException{

        Student student = getStudentUseCase.getStudentId(id);

        StudentOutputDto studentOutputDto = studentMapperDto.studentToStudentOutputDto(student);

        return new ResponseEntity<>(studentOutputDto, HttpStatus.OK);
    }



    @GetMapping
    public ResponseEntity<List<StudentOutputDto>> getAllStdents(){

        List<StudentOutputDto> studentOutputDtos = getStudentUseCase.getAll()
                .stream()
                .map(student ->
                {
                    StudentOutputDto studentOutput = studentMapperDto.studentToStudentOutputDto(student);
                    return studentOutput;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(studentOutputDtos, HttpStatus.OK);
    }


}
