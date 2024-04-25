package com.example.block7crudvalidation.student.infracstructure.controller.dto.input;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentInputDto {

    Integer num_hours_week;

    String comment;

    String branch; //Front, Back, FullStack.



    //FKs
    Long idPersona;

    Long idProfesor;


}
