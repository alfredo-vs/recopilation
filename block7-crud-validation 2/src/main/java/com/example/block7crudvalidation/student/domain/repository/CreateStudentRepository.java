package com.example.block7crudvalidation.student.domain.repository;

import com.example.block7crudvalidation.student.domain.entity.Student;

public interface CreateStudentRepository {

    Student createStudent(Student student) throws Exception;
}
