package com.example.block7crudvalidation.profesor.application.mappers;


import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.input.ProfesorInputDto;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutPutSinPersonaDto;
import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PersonaMapperDto.class})




public interface ProfesorMapperDto {




    @Mapping(source = "coments", target = "coments")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "idPersona", target = "persona.idPersona")
    Profesor inputDtoProfesorToProfesor(ProfesorInputDto profesorInputDto);




    @Mapping(source = "idProfesor", target = "idProfesor")
    @Mapping(source = "coments", target = "coments")
    @Mapping(source = "branch", target = "branch")
    @Mapping(source = "persona", target = "personaOutputDto")
    ProfesorOutputDto profesorToOutPutProfesor(Profesor profesor);


    @Mapping(source = "idProfesor", target = "idProfesor")
    @Mapping(source = "coments", target = "coments")
    @Mapping(source = "branch", target = "branch")
    ProfesorOutPutSinPersonaDto profesorToOutPutProfesorSinPersona(Profesor profesor);
}
