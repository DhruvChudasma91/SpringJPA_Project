package com.dhruv.JPA_Project01.service;

import com.dhruv.JPA_Project01.entity.Student;
import com.dhruv.JPA_Project01.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServise {

    @Autowired
    StudentRepo studentRepo;

    public Student saveStudent(Student student)
    {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudentData() {
        List<Student> list = studentRepo.findAll();
        return list;
    }

    public Student getStudentById(Integer id) {
        Optional<Student> byId = studentRepo.findById(id);
        Student student = byId.get();
        return student;
    }

    public Student updateStudent(Integer id, Student student)
    {
        Student std = null;
       Optional<Student> studentById = studentRepo.findById(id);
       if(studentById.isPresent()) {
           Student dbStudentObject = studentById.get();
           dbStudentObject.setAge(student.getAge());
           dbStudentObject.setName(student.getName());
           dbStudentObject.setEmail(student.getEmail());
           std = studentRepo.save(dbStudentObject);
       } else {
           System.out.println("Data not present in db....");
       }

       return std;
    }
}
