package com.Rohit.UniversityStudent.service;


import com.event.entities.Department;
import com.event.entities.Student;
import com.event.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepo studentRepo;

    public  Student getStudentById(int studentId) {
        return studentRepo.findById(studentId).orElseThrow(()->new IllegalArgumentException("Student Not found"));
    }

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public List<Student> getAllStudents() {
        return (List<Student>) studentRepo.findAll();
    }

    public void updateStudentDepartment(int studentId, Department department) {
        Student student =studentRepo.findById(studentId)
                .orElseThrow(()->new IllegalArgumentException("Student not found"));
        student.setDepartment(department);
        studentRepo.save(student);
    }

    public void deleteStudent(int studentId) {
        studentRepo.deleteById(studentId);
    }
}
