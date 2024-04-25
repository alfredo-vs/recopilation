package com.example.block7crudvalidation.persona.domain.entity;


import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.student.domain.entity.Student;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Persona {

    private Long idPersona;
    private String usuario;
    private String password;
    private String name;
    private String surname;
    private String companyEmail;
    private String personalEmail;
    private String city;
    private Boolean active;
    private LocalDate createdDate;
    private String imageUrl;
    private LocalDate terminationDate;

    Profesor profesor;
    Student student;


}
