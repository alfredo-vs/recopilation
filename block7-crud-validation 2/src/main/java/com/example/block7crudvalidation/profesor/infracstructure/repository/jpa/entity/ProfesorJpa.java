package com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity;

import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "profesor")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProfesorJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "profesor_id", nullable = false, unique = true)
    Long idProfesor;


    @OneToOne
    @JoinColumn(name = "persona_id_fk", referencedColumnName = "persona_id")
    PersonaJpa personaJpa;




    String coments;

    String branch;
}
