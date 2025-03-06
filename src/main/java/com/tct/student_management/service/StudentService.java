package com.tct.student_management.service;

import com.tct.student_management.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    List<Student> students = new ArrayList<>();

    public Student create(Student student) {
        students.add(student);
        return student;
    }

    public List<Student> read() {
        return students;
    }

    public Student getById(String id) {
        return students.stream()
                .filter(student -> student.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Student> searchByAge(Integer age) {
        return students.stream()
                .filter(student -> student.getAge().equals(age))
                .toList();
    }


    public Student update(String id, Student student) {
        Student originalStudent = students.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElse(null);

        students.set(students.indexOf(originalStudent), student);
        return student;
    }
}
