package com.example.block7crudvalidation.student.infracstructure.controller.dto.output;

import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutPutSinPersonaDto;

import lombok.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentOutputDto {

    // De student ******************

    Long id;

    Integer num_hours_week;

    String comment;

    String branch;


    PersonaOutputDto personaOutputDto;

    ProfesorOutPutSinPersonaDto profesorOutPutSinPersonaDto;
}
