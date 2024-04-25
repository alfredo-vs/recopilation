package com.example.block7crudvalidation.profesor.application.usecases.impl;

import com.example.block7crudvalidation.profesor.application.usecases.DeleteProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.domain.repository.DeleteProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteProfesorUseCaseImpl implements DeleteProfesorUseCase {

    @Autowired
    DeleteProfesorRepository deleteProfesorRepository;



    @Override
    public Profesor deleteProfesor(Long id) throws NotFoundException {

        return deleteProfesorRepository.deleteProfesor(id);
    }
}
