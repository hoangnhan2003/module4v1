package com.example.service;

import com.example.Dto.StudentDto;
import com.example.model.Student;

import java.util.List;

public interface IStudentService {
    List<StudentDto> getAll();
    void save(Student student);
    Student findById(Integer codeStudent);
}
