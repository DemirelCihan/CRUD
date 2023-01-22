package com.example.CRUD.controller;

import com.example.CRUD.Repository.StudentDao;
import com.example.CRUD.entities.concretes.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentDao studentDao;

    @Autowired
    public StudentController(StudentDao studentDao){
       this.studentDao = studentDao;

    }

    @GetMapping("/findAll")
    public List<Student> getAllStudents(){
        return studentDao.findAll();
    }

    @PostMapping("/save")
    public Student createStudent(@RequestBody Student student){
        return studentDao.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable int id, @RequestBody Student updateStudent){
        Student student =studentDao.findById(id).orElseThrow(() -> new IllegalArgumentException("Student not found with id" +id));
     student.setFirstName(updateStudent.getFirstName());
     student.setLastName(updateStudent.getLastName());
     student.setStudentNumber(updateStudent.getStudentNumber());
     return studentDao.save(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id){
        studentDao.deleteById(id);
    }

}
