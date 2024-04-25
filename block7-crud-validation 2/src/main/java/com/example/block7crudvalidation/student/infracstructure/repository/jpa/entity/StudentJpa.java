package com.example.block7crudvalidation.student.infracstructure.repository.jpa.entity;


import com.example.block7crudvalidation.persona.infrastructure.repository.jpa.entity.PersonaJpa;
import com.example.block7crudvalidation.profesor.infracstructure.repository.jpa.entity.ProfesorJpa;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "student")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentJpa {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id", nullable = false, unique = true)
    Long id;

    Integer num_hours_week;

    String comment;

    String branch; //Front, Back, FullStack.





    //De otras clases ...

    @OneToOne
    @JoinColumn(name = "persona_id_fk", referencedColumnName = "persona_id")
    PersonaJpa personaJpa;


    @OneToOne
    @JoinColumn(name = "profesor_id_fk", referencedColumnName = "profesor_id")
    ProfesorJpa profesorJpa;
}
