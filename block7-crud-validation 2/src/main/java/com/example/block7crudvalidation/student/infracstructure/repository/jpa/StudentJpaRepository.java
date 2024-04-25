package com.example.block7crudvalidation.student.infracstructure.repository.jpa;
import com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity.StudentJpa;
import org.springframework.data.jpa.repository.JpaRepository;



public interface StudentJpaRepository extends JpaRepository<StudentJpa, Long> {


}
