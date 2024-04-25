package com.example.block7crudvalidation.persona.application.usecases.impl;

import com.example.block7crudvalidation.persona.application.usecases.EditPersonaUseCase;
import com.example.block7crudvalidation.persona.application.validation.PersonaValidation;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.EditPersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditPersonaUseCaseImpl implements EditPersonaUseCase {

    @Autowired
    EditPersonaRepository editPersonaRepository;

    @Override
    public Persona edit(Long id, Persona persona) throws Exception {

        PersonaValidation.checkAllValidationForPersona(persona);

        return editPersonaRepository.editPersona(id, persona);
    }


}
