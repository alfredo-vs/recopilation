package com.example.block7crudvalidation.student.infracstructure.controller;


import com.example.block7crudvalidation.student.application.mappers.StudentMapperDto;
import com.example.block7crudvalidation.student.application.usecases.DeleteStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.output.StudentOutputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class DeleteStudentController {

    @Autowired
    DeleteStudentUseCase deleteStudentUseCase;

    @Autowired
    StudentMapperDto studentMapperDto;


    @DeleteMapping("/{id}")
    public ResponseEntity<StudentOutputDto> deleteStudent(@PathVariable Long id) throws NotFoundException{

        Student student = deleteStudentUseCase.delelteStudent(id);

        StudentOutputDto studentOutputDto = studentMapperDto.studentToStudentOutputDto(student);

        return new ResponseEntity<>(studentOutputDto, HttpStatus.OK);

    }


}


