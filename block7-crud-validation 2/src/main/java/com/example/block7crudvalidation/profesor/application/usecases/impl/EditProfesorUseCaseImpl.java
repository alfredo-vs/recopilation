package com.example.block7crudvalidation.profesor.application.usecases.impl;

import com.example.block7crudvalidation.profesor.application.usecases.EditProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.domain.repository.EditProfesorRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditProfesorUseCaseImpl implements EditProfesorUseCase {

    @Autowired
    EditProfesorRepository editProfesorRepository;



    @Override
    public Profesor editProfesor(Long id, Profesor profesor) throws NotFoundException {
        return editProfesorRepository.editProfesor(id, profesor);
    }
}
