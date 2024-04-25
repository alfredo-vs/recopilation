package com.example.block7crudvalidation.profesor.application.usecases.impl;

import com.example.block7crudvalidation.profesor.application.usecases.GetProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.domain.repository.GetProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProfesorUseCaseImpl implements GetProfesorUseCase {

    @Autowired
    GetProfesorRepository getProfesorRepository;


    @Override
    public Profesor getById(Long id) throws NotFoundException {
        return getProfesorRepository.getProfesorId(id);
    }

    @Override
    public List<Profesor> getAll() {
        return getProfesorRepository.getAllProfesor();
    }
}
