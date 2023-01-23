package com.example.CRUD.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity
@Table(name = "students")
@AllArgsConstructor
@NoArgsConstructor

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String  lastName;
    @Column(name = "student_number")
    private int studentNumber;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "email")
    private String email;
    @Column(name = "is_on_budget")
    private Boolean isOnBudget;

    @OneToMany(mappedBy = "student")
    @JsonIgnore
    private List<Project> projects;





}
