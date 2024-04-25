package com.example.block7crudvalidation.persona.application.usecases.impl;

import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.GetPersonaRepository;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPersonaUseCaseImpl implements GetPersonaUseCase {

    @Autowired
    GetPersonaRepository personaRepository;

    @Override
    public Persona getById(Long id) throws NotFoundException {
        return personaRepository.getPersonaId(id);
    }

    @Override
    public List<Persona> getAll() {
        return personaRepository.getPersonaAll();
    }

    @Override
    public List<Persona> getPersonaUsuario(String usuario) {
        return personaRepository.getPersonaUsuario(usuario);
    }

}
