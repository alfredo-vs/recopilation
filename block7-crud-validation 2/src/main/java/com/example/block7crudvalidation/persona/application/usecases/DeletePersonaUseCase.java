package com.example.block7crudvalidation.persona.application.usecases;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;


public interface DeletePersonaUseCase {
    Persona delete (Long id) throws NotFoundException;
}
