package com.example.block7crudvalidation.student.application.usecases.impl;

import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.application.usecases.GetProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperDto;
import com.example.block7crudvalidation.student.application.usecases.CreateStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.CreateStudentRepository;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.input.StudentInputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CreateStudentUseCaseImpl implements CreateStudentUseCase {

    @Autowired
    CreateStudentRepository createStudentRepository;

    @Autowired
    GetPersonaUseCase getPersonaUseCase;

    @Autowired
    GetProfesorUseCase getProfesorUseCase;

    @Autowired
    StudentMapperDto studentMapperDto;


    @Override
    public Student createStudent(StudentInputDto studentInputDto) throws Exception {

        Student student = studentMapperDto.studentInputDtoToStudent(studentInputDto);

        Long idPersona = Optional.ofNullable(student.getPersona().getIdPersona()).orElse(null);

        if (Objects.nonNull(idPersona)){
            student.setPersona(getPersonaUseCase.getById(idPersona));
        }


        Long idProfesor = Optional.ofNullable(student.getProfesor().getIdProfesor()).orElse(null);

        if (Objects.nonNull(idProfesor)){
            student.setProfesor(getProfesorUseCase.getById(idProfesor));
        }


        return createStudentRepository.createStudent(student);
    }
}
