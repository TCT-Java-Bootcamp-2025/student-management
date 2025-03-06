package com.tct.student_management.controller;

import com.tct.student_management.model.Student;
import com.tct.student_management.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //CRUD operations per klasen student
    //1. Create student: Endpoint POST method
    //JSON RequestBody:
    // {
    //    "id": "ID-01",
    //    "name": "Adela",
    //    "age": 20,
    //    "gender": "F"
    //}
    //Example: http://localhost:8080/api/student
    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentService.create(student);
    }

    //2. Read students: Endpoint GET method
    //Example: http://localhost:8080/api/student
    @GetMapping
    public List<Student> read() {
        return studentService.read();
    }

    //Example for id = ID-01: http://localhost:8080/api/student/ID-01
    @GetMapping("/{id}")
    public Student getById(@PathVariable String id) {
        return studentService.getById(id);
    }

    //example: http://localhost:8080/api/student/search?age=20
    @GetMapping("/search")
    public List<Student> search(@RequestParam Integer age) {
        return studentService.searchByAge(age);
    }


    //3. Update students: Endpoint PUT method
    //Example update element with id= ID-01: http://localhost:8080/api/student/ID-01
    //      {
    //        "id": "ID-01",
    //        "name": "Adela",
    //        "age": 21,
    //        "gender": "F"
    //      }
    @PutMapping("/{id}")
    public Student update(@PathVariable String id, @RequestBody Student student) {
        return studentService.update(id, student);
    }

    //4. Delete student: Endpoint DELETE method
}
