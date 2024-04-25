package com.example.block7crudvalidation.profesor.application.usecases.impl;

import com.example.block7crudvalidation.persona.application.usecases.GetPersonaUseCase;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.profesor.application.usecases.CreateProfesorUseCase;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.domain.repository.CreateProfesorRepository;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.input.ProfesorInputDto;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class CreateProfesorUseCaseImpl implements CreateProfesorUseCase {

    @Autowired
    CreateProfesorRepository createProfesorRepository;

    @Autowired
    GetPersonaUseCase getPersonaUseCase;

    @Autowired
    ProfesorMapperDto profesorMapperDto;


    @Override
    public Profesor createProfesor(ProfesorInputDto profesorInputDto) throws NotFoundException {

        Profesor profesor = profesorMapperDto.inputDtoProfesorToProfesor(profesorInputDto);

        Long idPersona = Optional.ofNullable(profesor.getPersona().getIdPersona()).orElse(null);


        if (Objects.nonNull(idPersona)){
            profesor.setPersona(getPersonaUseCase.getById(idPersona));
        }
        

        return createProfesorRepository.createProfesor(profesor);
    }
}
