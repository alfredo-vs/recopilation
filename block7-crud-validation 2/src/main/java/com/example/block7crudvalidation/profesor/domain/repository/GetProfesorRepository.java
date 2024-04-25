package com.example.block7crudvalidation.profesor.domain.repository;

import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

import java.util.List;


public interface GetProfesorRepository {

    Profesor getProfesorId(Long id) throws NotFoundException;

    List<Profesor>getAllProfesor();
}
