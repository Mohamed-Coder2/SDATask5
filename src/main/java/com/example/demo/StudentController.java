package com.example.demo;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    private ArrayList<Student> studentList = new ArrayList<>();

    @GetMapping
    public ArrayList<Student> getAllStudents() {
        return studentList;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getStudent(@PathVariable int id) {
        for (Student s : studentList) {
            if(s.getId() == id) return ResponseEntity.ok("Student Found, Name is " + s.getName());
        }
        return ResponseEntity.status(NOT_FOUND).body("Student with ID " + id + "Not Found");
    }

    @PostMapping
    public ResponseEntity<String> addStudent(@RequestBody Student student) {
        studentList.add(student);
        return ResponseEntity.status(CREATED).body("Student added: " + student.getName());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                studentList.remove(s);
                return ResponseEntity.ok("Student with ID " + id + " deleted");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStudent(@PathVariable int id, @RequestBody Student updatedStudent) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                s.setName(updatedStudent.getName());
                s.setId(updatedStudent.getId());
                return ResponseEntity.ok("Student with ID " + id + " updated");
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student with ID " + id + " not found");
    }
}