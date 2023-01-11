package com.example.repository.Impl;

import com.example.model.Student;
import com.example.repository.IStudentRepository;

import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository implements IStudentRepository {

    @Override
    public List<Student> getAll() {
        List<Student> students = BaseRepository.entityManager.createQuery("select s from Student s",Student.class).getResultList();
        return students;
    }

    @Override
    public void save(Student student) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(student);
        entityTransaction.commit();
    }

    @Override
    public Student findById(Integer id) {
        Student student = BaseRepository.entityManager.createQuery("select s from Student s where s.codeStudent = ?1",Student.class).setParameter(1,id).getSingleResult();
        return student;
    }
}
