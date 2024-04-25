package com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output;


import com.example.block7crudvalidation.persona.infrastructure.controller.dto.output.PersonaOutputDto;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProfesorOutputDto {

    Long idProfesor;

    String coments;

    String branch;



    PersonaOutputDto personaOutputDto;
}
