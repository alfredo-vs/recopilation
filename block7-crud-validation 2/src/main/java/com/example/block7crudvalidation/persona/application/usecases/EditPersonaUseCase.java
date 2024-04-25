package com.example.block7crudvalidation.persona.application.usecases;

import com.example.block7crudvalidation.persona.domain.entity.Persona;


public interface EditPersonaUseCase {
    Persona edit(Long id, Persona persona) throws Exception;
}
