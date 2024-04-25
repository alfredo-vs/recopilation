package com.example.block7crudvalidation.student.application.usecases.impl;

import com.example.block7crudvalidation.student.application.usecases.DeleteStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.DeleteStudentRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteStudentUseCaseImpl implements DeleteStudentUseCase {

    @Autowired
    DeleteStudentRepository deleteStudentRepository;


    @Override
    public Student delelteStudent(Long id) throws NotFoundException {
        return deleteStudentRepository.deleteStudent(id);
    }
}
