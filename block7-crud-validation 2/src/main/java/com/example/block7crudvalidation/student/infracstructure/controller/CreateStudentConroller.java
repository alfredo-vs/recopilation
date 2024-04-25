package com.example.block7crudvalidation.student.infracstructure.controller;

import com.example.block7crudvalidation.student.application.mappers.StudentMapperDto;
import com.example.block7crudvalidation.student.application.usecases.CreateStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.input.StudentInputDto;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.output.StudentOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class CreateStudentConroller{

    @Autowired
    CreateStudentUseCase createStudentUseCase;


    @Autowired
    StudentMapperDto studentMapperDto;



    @PostMapping
    public ResponseEntity<StudentOutputDto> createStudent(@RequestBody StudentInputDto studentInputDto) throws Exception{


        Student student = createStudentUseCase.createStudent(studentInputDto);

        StudentOutputDto studentOutputDto = studentMapperDto.studentToStudentOutputDto(student);


        return new ResponseEntity<>(studentOutputDto, HttpStatus.CREATED);
    }




}
