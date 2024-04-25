package com.example.block7crudvalidation.persona.application.validation;
import com.example.block7crudvalidation.persona.domain.entity.Persona;
import com.example.block7crudvalidation.z_shared.exceptions.UnprocessableEntityException;

import java.util.Objects;

public class PersonaValidation {

    public static boolean checkUsuarioIsNotNull(Persona persona){
        return !Objects.isNull(persona.getUsuario());
    }

    public static boolean checkUsuarioLenghtLessThanTen(Persona persona){
        return persona.getUsuario().length() < 10;
    }


    public static boolean checkAllValidationForPersona(Persona persona) throws Exception {

        if(!checkUsuarioIsNotNull(persona)){
            throw new UnprocessableEntityException("El usuario no puede ser nulo");
            //throw new Exception("El usuario no puede ser nulo");
        }

        if(!checkUsuarioLenghtLessThanTen(persona)){
            throw new UnprocessableEntityException("Longitud de usuario no puede ser superior a 10 caracteres");
            //throw new Exception("Longitud de usuario no puede ser superior a 10 caracteres");
        }


        return true;
    }
}
