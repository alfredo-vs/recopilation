package com.example.block7crudvalidation.student.application.mappers;

import com.example.block7crudvalidation.persona.application.mappers.PersonaMapperDto;
import com.example.block7crudvalidation.profesor.application.mappers.ProfesorMapperDto;
import com.example.block7crudvalidation.student.domain.entity.Student;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.input.StudentInputDto;
import com.example.block7crudvalidation.student.infracstructure.controller.dto.output.StudentOutputDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


@Mapper(componentModel = MappingConstants.ComponentModel.SPRING , uses = {PersonaMapperDto.class, ProfesorMapperDto.class})
public interface StudentMapperDto {

    @Mapping(source = "num_hours_week" , target = "num_hours_week")
    @Mapping(source = "comment" , target = "comment")
    @Mapping(source = "branch" , target = "branch")

    @Mapping(source = "idPersona" , target = "persona.idPersona")
    @Mapping(source = "idProfesor" , target = "profesor.idProfesor")
    Student studentInputDtoToStudent(StudentInputDto studentInputDto);







    @Mapping(source = "num_hours_week" , target = "num_hours_week")
    @Mapping(source = "comment" , target = "comment")
    @Mapping(source = "branch" , target = "branch")
    @Mapping(source = "id" , target = "id")

    @Mapping(source = "persona" , target = "personaOutputDto")
    @Mapping(source = "profesor" , target = "profesorOutPutSinPersonaDto")
    StudentOutputDto studentToStudentOutputDto(Student student);

}
