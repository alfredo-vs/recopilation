package com.example.block7crudvalidation.persona.application.usecases;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

import java.util.List;

public interface GetPersonaUseCase {

    Persona getById(Long id) throws NotFoundException;

    List<Persona> getAll();

    List<Persona> getPersonaUsuario(String usuario);
}


