package com.example.block7crudvalidation.profesor.domain.entity;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Profesor {

    Long idProfesor;

    String coments;

    String branch;


    Persona persona;
}
