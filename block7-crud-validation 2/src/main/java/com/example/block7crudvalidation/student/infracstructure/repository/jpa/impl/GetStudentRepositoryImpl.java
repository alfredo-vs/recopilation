package com.example.block7crudvalidation.student.infracstructure.repository.jpa.impl;


import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperJpa;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.GetStudentRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.StudentJpaRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class GetStudentRepositoryImpl implements GetStudentRepository {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Autowired
    StudentMapperJpa studentMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;


    @Override
    public Student getStudentId(Long id) throws NotFoundException {

        StudentJpa studentJpa = studentJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student no encontrado con el Id: "+ id));

        Student student = studentMapperJpa.studentJpaToStudent(studentJpa);

        student.setPersona(personaMapperJpa.personaJpaToPersona(studentJpa.getPersonaJpa()));
        student.setProfesor(profesorMapperJpa.profesorJpaToProfesor(studentJpa.getProfesorJpa()));


        return student;
    }

    @Override
    public List<Student> getAll() {
        return studentJpaRepository.findAll()
                .stream()
                .map(studentJpa ->
                {
                    Student student = studentMapperJpa.studentJpaToStudent(studentJpa);

                    student.setPersona(personaMapperJpa.personaJpaToPersona(studentJpa.getPersonaJpa()));
                    student.setProfesor(profesorMapperJpa.profesorJpaToProfesor(studentJpa.getProfesorJpa()));

                    return student;
                })
                .collect(Collectors.toList());
    }
}

