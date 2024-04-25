package com.example.block7crudvalidation.persona.domain.repository;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;

import java.util.List;


public interface GetPersonaRepository {

    Persona getPersonaId(Long id) throws NotFoundException;

    List<Persona> getPersonaAll();

    List<Persona> getPersonaUsuario(String usuario);
}
