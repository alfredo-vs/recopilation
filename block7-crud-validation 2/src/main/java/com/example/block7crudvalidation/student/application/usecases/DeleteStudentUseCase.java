package com.example.block7crudvalidation.student.application.usecases;

import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

public interface DeleteStudentUseCase {

    Student delelteStudent(Long id) throws NotFoundException;
}
