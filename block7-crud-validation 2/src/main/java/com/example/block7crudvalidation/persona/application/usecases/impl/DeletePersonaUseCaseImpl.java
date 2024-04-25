package com.example.block7crudvalidation.persona.application.usecases.impl;


import com.example.block7crudvalidation.persona.application.usecases.DeletePersonaUseCase;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.persona.domain.repository.DeletePersonaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.PersonaJpaRepository;
import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.ProfesorJpaRepository;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.z_shared.exceptions.NotFoundException;
import com.example.block7crudvalidation.z_shared.exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeletePersonaUseCaseImpl implements DeletePersonaUseCase {

    @Autowired
    DeletePersonaRepository deletePersonaRepository;

    @Autowired
    ProfesorJpaRepository profesorJpaRepository;

    @Autowired
    PersonaJpaRepository personaJpaRepository;


    @Override
    public Persona delete(Long id) throws NotFoundException {

        checkThereIsNotProfesorWithThisPersonId(id);
        return deletePersonaRepository.deletePersona(id);
    }



    private void checkThereIsNotProfesorWithThisPersonId(Long id){
        System.out.println("Pasar por aquí paso.");

        PersonaJpa personaJpa = personaJpaRepository.findById(id).orElseThrow();

        if (profesorJpaRepository.existsByPersonaJpa(personaJpa)){

            ProfesorJpa profesorJpa = profesorJpaRepository.findByPersonaJpa(personaJpa);


            throw new UnprocessableEntityException("El profesor con id: " + profesorJpa.getIdProfesor()
                    + " está relacionado con esta persona de modo que para borrar a esta persona "
                    + "primero debes borrar a ese profesor.");
        }


    }
}
