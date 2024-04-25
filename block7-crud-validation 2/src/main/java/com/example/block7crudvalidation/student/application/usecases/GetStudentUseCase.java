package com.example.block7crudvalidation.student.application.usecases;

import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

import java.util.List;

public interface GetStudentUseCase {

    Student getStudentId(Long id) throws NotFoundException;

    List<Student> getAll();
}
