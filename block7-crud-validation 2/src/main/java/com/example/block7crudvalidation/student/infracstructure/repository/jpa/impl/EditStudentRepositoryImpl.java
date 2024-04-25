package com.example.block7crudvalidation.student.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperJpa;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.EditStudentRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.StudentJpaRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Objects;

@Repository
public class EditStudentRepositoryImpl implements EditStudentRepository {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Autowired
    StudentMapperJpa studentMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;




    @Override
    public Student editStudent(Long id, Student student) throws NotFoundException {

        StudentJpa studentJpa = studentJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student no encontrado con el Id" + id));

        if (Objects.nonNull(student.getBranch()))
            studentJpa.setBranch(student.getBranch());

        if(Objects.nonNull(student.getComment()))
            studentJpa.setComment(student.getComment());

        if(Objects.nonNull(student.getNum_hours_week()))
            studentJpa.setNum_hours_week(student.getNum_hours_week());


        studentJpaRepository.save(studentJpa);

        student = studentMapperJpa.studentJpaToStudent(studentJpa);

        student.setProfesor(profesorMapperJpa.profesorJpaToProfesor(studentJpa.getProfesorJpa()));
        student.setPersona(personaMapperJpa.personaJpaToPersona(studentJpa.getPersonaJpa()));


        return student;
    }
}
