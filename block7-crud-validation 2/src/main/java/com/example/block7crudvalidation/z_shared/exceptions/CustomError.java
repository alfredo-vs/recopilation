package com.example.block7crudvalidation.z_shared.exceptions;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CustomError implements Serializable {

    private LocalDateTime timeStamp;

    private Integer httpCode;

    private String mensaje;


}
