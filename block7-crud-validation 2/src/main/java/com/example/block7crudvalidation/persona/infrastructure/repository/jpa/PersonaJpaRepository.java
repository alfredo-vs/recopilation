package com.example.block7crudvalidation.persona.infrastructure.repository.jpa;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonaJpaRepository extends JpaRepository<PersonaJpa, Long> {

    List<PersonaJpa> findAllByUsuario(String usuario);
}
