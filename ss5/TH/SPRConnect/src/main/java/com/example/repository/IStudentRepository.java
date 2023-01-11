package com.example.repository;

import com.example.model.Student;

import java.util.List;

public interface IStudentRepository {
    List<Student> getAll();
    void save(Student student);
    Student findById(Integer id);
}
