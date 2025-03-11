package com.tct.student_management.service;

import com.tct.student_management.entity.StudentEntity;
import com.tct.student_management.model.Student;
import com.tct.student_management.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    //Constructor DI per repository-in e student
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentEntity create(StudentEntity student) {

        return studentRepository.save(student);
    }

    public List<StudentEntity> read() {
        return studentRepository.findAll();
    }

    public StudentEntity getById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public List<StudentEntity> searchByAge(Integer age) {
        return studentRepository.findByAge(age);
    }


    public StudentEntity update(String id, StudentEntity student) {
        return studentRepository.save(student);
    }

    public void deleteById(Long id) {
        studentRepository.deleteById(id);
    }
}
