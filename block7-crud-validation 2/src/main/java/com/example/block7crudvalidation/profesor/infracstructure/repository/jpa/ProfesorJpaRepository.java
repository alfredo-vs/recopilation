package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorJpaRepository extends JpaRepository<ProfesorJpa, Long> {

    public boolean existsByPersonaJpa(PersonaJpa personaJpa);

    public ProfesorJpa findByPersonaJpa(PersonaJpa personaJpa);

}