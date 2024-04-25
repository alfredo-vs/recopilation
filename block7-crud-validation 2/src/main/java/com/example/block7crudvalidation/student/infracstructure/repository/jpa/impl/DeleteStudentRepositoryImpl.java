package com.example.block7crudvalidation.student.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperJpa;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.DeleteStudentRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.StudentJpaRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DeleteStudentRepositoryImpl implements DeleteStudentRepository {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Autowired
    StudentMapperJpa studentMapperJpa;


    @Autowired
    PersonaMapperJpa personaMapperJpa;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;



    @Override
    public Student deleteStudent(Long id) throws NotFoundException {

        StudentJpa studentJpa = studentJpaRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Student no encontrando con Id: " + id));

        Student student = studentMapperJpa.studentJpaToStudent(studentJpa);

        Persona personaDeStudent = personaMapperJpa.personaJpaToPersona(studentJpa.getPersonaJpa());
        student.setPersona(personaDeStudent);

        Profesor profesorDeStudent = profesorMapperJpa.profesorJpaToProfesor(studentJpa.getProfesorJpa());
        student.setProfesor(profesorDeStudent);

        studentJpaRepository.delete(studentJpa);

        return student;
    }
}
