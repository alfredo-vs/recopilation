package com.example.block7crudvalidation.z_shared.feign;

import com.example.block7crudvalidation.profesor.infracstructure.controller.dto.output.ProfesorOutputDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(url = "http://localhost:8081", name = "mainAppClient")
public interface MyFeign {


    @GetMapping("/profesor/{id}")
    public ResponseEntity<ProfesorOutputDto> getProfesorId(@PathVariable Long id);
}
