package com.example.block7crudvalidation.profesor.domain.repository;

import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

public interface DeleteProfesorRepository {

    Profesor deleteProfesor(Long id) throws NotFoundException;
}
