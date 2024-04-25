package com.example.block7crudvalidation.profesor.application.usecases;

import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

public interface DeleteProfesorUseCase {

    Profesor deleteProfesor(Long id) throws NotFoundException;
}
