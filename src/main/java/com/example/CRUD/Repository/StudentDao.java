package com.example.CRUD.Repository;

import com.example.CRUD.entities.concretes.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDao extends JpaRepository<Student,Integer> {

}
