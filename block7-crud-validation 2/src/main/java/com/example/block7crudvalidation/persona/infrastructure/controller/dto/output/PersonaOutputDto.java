package com.example.block7crudvalidation.persona.infrastructure.controller.dto.output;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PersonaOutputDto{

    private Long idPersona;
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
