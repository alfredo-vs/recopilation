package com.example.block7crudvalidation.student.application.usecases.impl;

import com.example.block7crudvalidation.student.application.usecases.EditStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.EditStudentRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditStudentUseCaseImpl implements EditStudentUseCase {



    @Autowired
    EditStudentRepository editStudentRepository;



    @Override
    public Student editStudent(Long id, Student student) throws NotFoundException {
        return editStudentRepository.editStudent(id, student);
    }
}
