package com.example.block7crudvalidation.persona.domain.repository;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

public interface DeletePersonaRepository {
    Persona deletePersona (Long id) throws NotFoundException;
}
