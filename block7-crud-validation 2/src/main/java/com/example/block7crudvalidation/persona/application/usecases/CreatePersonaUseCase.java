package com.example.block7crudvalidation.persona.application.usecases;

import com.example.block7crudvalidation.persona.domain.entity.Persona;


public interface CreatePersonaUseCase {
    Persona create(Persona persona) throws Exception;
}
