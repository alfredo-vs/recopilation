package com.example.block7crudvalidation.profesor.application.usecases;

import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

import java.util.List;

public interface GetProfesorUseCase {

    Profesor getById(Long id) throws NotFoundException;

    List<Profesor> getAll();
}
