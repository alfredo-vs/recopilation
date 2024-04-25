package com.example.block7crudvalidation.student.infracstructure.repository.jpa.impl;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperJpa;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperJpa;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.student.application.mappers.StudentMapperJpa;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.CreateStudentRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.StudentJpaRepository;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CreateStudentRepositoryImpl implements CreateStudentRepository {

    @Autowired
    StudentJpaRepository studentJpaRepository;

    @Autowired
    PersonaJpaRepository personaJpaRepository;

    @Autowired
    StudentMapperJpa studentMapperJpa;

    @Autowired
    PersonaMapperJpa personaMapperJpa;

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    ProfesorMapperJpa profesorMapperJpa;



    @Override
    public Student createStudent(Student student) throws Exception {

        // Instanciamos  studentJpa
        StudentJpa studentJpa = studentMapperJpa.studentToStudentJpa(student);


        // Le asignamos una persona.
        PersonaJpa personaJpa = personaJpaRepository.findById(student.getPersona().getIdPersona()).orElseThrow(
                () -> new NotFoundException("Persona no encontrada"));

        studentJpa.setPersonaJpa(personaJpa);

        // Le asignamos su profesor.
        ProfesorJpa profesorJpa = profesorJpaRepository.findById(student.getProfesor().getIdProfesor()).orElseThrow(
                () -> new NotFoundException("Profesor no encontrado"));

        studentJpa.setProfesorJpa(profesorJpa);


        // Guardamos en el repositorio.
        studentJpa = studentJpaRepository.save(studentJpa);


        // Instanciamos el Student que será devuelto

        Student studentDevuelto = studentMapperJpa.studentJpaToStudent(studentJpa);

        // Le asignamos a ese estudiante una persona así como un profesor.
        studentDevuelto.setPersona(personaMapperJpa.personaJpaToPersona(personaJpa));
        studentDevuelto.setProfesor(profesorMapperJpa.profesorJpaToProfesor(profesorJpa));



        return studentDevuelto;
    }
}
