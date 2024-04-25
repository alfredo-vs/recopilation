package com.example.block7crudvalidation.student.infracstructure.controller;


import com.example.block7crudvalidation.student.application.mappers.StudentMapperDto;
import com.example.block7crudvalidation.student.application.usecases.EditStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.input.StudentInputDto;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.output.StudentOutputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class EditStudentController {

    @Autowired
    EditStudentUseCase editStudentUseCase;

    @Autowired
    StudentMapperDto studentMapperDto;



    @PutMapping("/{id}")
    public ResponseEntity<StudentOutputDto> editStudent(@PathVariable Long id,
    @RequestBody StudentInputDto studentInputDto) throws NotFoundException{

        Student student = studentMapperDto.studentInputDtoToStudent(studentInputDto);

        student = editStudentUseCase.editStudent(id, student);

        StudentOutputDto studentOutputDto = studentMapperDto.studentToStudentOutputDto(student);

        return new ResponseEntity<>(studentOutputDto, HttpStatus.OK);

    }
}
