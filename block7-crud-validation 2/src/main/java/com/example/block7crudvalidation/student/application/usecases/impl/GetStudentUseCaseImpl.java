package com.example.block7crudvalidation.student.application.usecases.impl;

import com.example.block7crudvalidation.student.application.usecases.GetStudentUseCase;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.domain.repository.GetStudentRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStudentUseCaseImpl implements GetStudentUseCase {

    @Autowired
    GetStudentRepository getStudentRepository;



    @Override
    public Student getStudentId(Long id) throws NotFoundException {
        return getStudentRepository.getStudentId(id);
    }

    @Override
    public List<Student> getAll() {
        return getStudentRepository.getAll();
    }
}
