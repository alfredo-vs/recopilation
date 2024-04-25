package com.example.block7crudvalidation.persona.application.usecases.impl;


import com.example.block7crudvalidation.persona.application.usecases.CreatePersonaUseCase;
import com.example.block7crudvalidation.persona.application.validation.PersonaValidation;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.CreatePersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePersonaUseCaseImpl implements CreatePersonaUseCase {

    @Autowired
    CreatePersonaRepository createPersonaRepository;

    @Override
    public Persona create(Persona persona) throws Exception {


        PersonaValidation.checkAllValidationForPersona(persona);

        return createPersonaRepository.createPersona(persona);
    }
}
