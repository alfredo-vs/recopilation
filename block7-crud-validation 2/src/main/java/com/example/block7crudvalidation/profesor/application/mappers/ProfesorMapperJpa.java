package com.example.block7crudvalidation.profesor.application.mappers;

import com.example.block7crudvalidation.profesor.domain.entity.Profesor;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProfesorMapperJpa {


    ProfesorJpa profesorToProfesorJpa(Profesor profesor);



    @InheritInverseConfiguration
    Profesor profesorJpaToProfesor(ProfesorJpa profesorJpa);

}
