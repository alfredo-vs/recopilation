package com.example.block7crudvalidation.student.application.usecases;

import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.input.StudentInputDto;


public interface CreateStudentUseCase {

    Student createStudent (StudentInputDto studentInputDto) throws Exception;
}
