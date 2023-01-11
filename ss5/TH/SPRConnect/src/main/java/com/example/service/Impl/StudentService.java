package com.example.service.Impl;

import com.example.Dto.StudentDto;
import com.example.model.Student;
import com.example.repository.IStudentRepository;
import com.example.service.IStudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {
    @Autowired
    IStudentRepository studentRepository;


    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.getAll();
        List<StudentDto> studentDtos = new ArrayList<>();
        StudentDto studentDto;
        for(Student student : students){
            studentDto = new StudentDto();
            BeanUtils.copyProperties(student,studentDto);
            studentDtos.add(studentDto);
        }
        return studentDtos;
    }

    @Override
    public void save(Student student) {
        if(student.getPoint() > 0 && student.getPoint() < 10){
            this.studentRepository.save(student);
        }
    }

    @Override
    public Student findById(Integer codeStudent) {
        return studentRepository.findById(codeStudent);
    }
}
