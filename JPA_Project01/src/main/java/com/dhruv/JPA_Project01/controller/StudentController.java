package com.dhruv.JPA_Project01.controller;

import com.dhruv.JPA_Project01.entity.Student;
import com.dhruv.JPA_Project01.service.StudentServise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/std")
public class StudentController {

    @Autowired
    private StudentServise servise;

    @PostMapping("/save")
    public Student creteStudent(@RequestBody Student student)
    {
        return servise.saveStudent(student);
    }

    @GetMapping("/all")
    public List<Student> getAllStudents()
    {
        List<Student> allStudentData = servise.getAllStudentData();
        return  allStudentData;
    }

    @GetMapping
    public Student getStudentById(@RequestParam Integer id)
    {
        return servise.getStudentById(id);
    }
    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable Integer id, @RequestBody Student student)
    {
        Student updateStudent = servise.updateStudent(id, student);
        return updateStudent;
    }

}
