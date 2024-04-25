package com.example.block7crudvalidation.student.application.mappers;


import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface StudentMapperJpa {

    StudentJpa studentToStudentJpa (Student student);

    @InheritInverseConfiguration
    Student studentJpaToStudent(StudentJpa studentJpa);
}
