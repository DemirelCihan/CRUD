package com.example.CRUD.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "projects")
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "project_name")
    private String projectName;
    @Column(name = "project_description")
    private String projectDescription;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private Student student;



}

