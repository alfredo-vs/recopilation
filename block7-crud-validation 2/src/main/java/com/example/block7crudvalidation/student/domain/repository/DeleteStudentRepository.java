package com.example.block7crudvalidation.student.domain.repository;

import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

public interface DeleteStudentRepository {
    Student deleteStudent(Long id) throws NotFoundException;
}
