package com.tct.student_management.controller;

import com.tct.student_management.entity.StudentEntity;
import com.tct.student_management.exception.StudentNotFoundException;
import com.tct.student_management.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

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
    //    "name": "Adela",
    //    "age": 20,
    //    "gender": "F"
    //}
    //Example: http://localhost:8080/api/student
    @PostMapping
    public ResponseEntity<StudentEntity> create(@RequestBody StudentEntity student) {
//        if (Objects.nonNull(studentService.getById(student.getId()))) {
//            throw new StudentAlreadyExistException("Student with id " + student.getId() + " already exists");
//        }

        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.create(student));
    }

    //2. Read students: Endpoint GET method
    //Example: http://localhost:8080/api/student
    @GetMapping
    public List<StudentEntity> read() {
        return studentService.read();
    }

    //Example for id = ID-01: http://localhost:8080/api/student/ID-01
    @GetMapping("/{id}")
    public ResponseEntity<StudentEntity> getById(@PathVariable Long id) {

        StudentEntity student = studentService.getById(id);
        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("Student with id " + id + " not found");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student);
    }

    //example: http://localhost:8080/api/student/search?age=20
    @GetMapping("/search")
    public ResponseEntity<List<StudentEntity>> search(@RequestParam Integer age) {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.searchByAge(age));
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
    public StudentEntity update(@PathVariable String id, @RequestBody StudentEntity student) {
        return studentService.update(id, student);
    }

    //4. Delete student: Endpoint DELETE method
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        studentService.deleteById(id);
    }
}
