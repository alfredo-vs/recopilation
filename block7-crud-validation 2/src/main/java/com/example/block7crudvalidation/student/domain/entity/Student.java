package com.example.block7crudvalidation.student.domain.entity;

import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student{

    Long id;

    Integer num_hours_week;

    String comment;

    String branch; //Front, Back, FullStack.




    // De otras clases
    Persona persona;

    Profesor profesor;
}
