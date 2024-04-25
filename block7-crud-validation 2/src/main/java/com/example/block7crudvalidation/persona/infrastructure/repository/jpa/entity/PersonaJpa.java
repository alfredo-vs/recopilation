package com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity;


import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;


@Entity
@Table(name = "persona")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonaJpa {

    @Column(name = "persona_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPersona;

    @OneToOne
    private ProfesorJpa profesorJpa;

    @OneToOne
    private StudentJpa studentJpa;


    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private boolean active;
    private LocalDate createdDate;
    private String imageUrl;
    private LocalDate terminationDate;
}
