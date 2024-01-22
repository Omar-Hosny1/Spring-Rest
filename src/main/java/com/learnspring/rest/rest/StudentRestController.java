package com.learnspring.rest.rest;

import com.learnspring.rest.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    List<Student> students;

    @PostConstruct
    public void loadData() {
        students = new ArrayList<Student>();

        students.add(new Student("Omar1", "Hosny"));
        students.add(new Student("Omar 2", "Hosny"));
        students.add(new Student("Omar3", "Hosny"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudents(@PathVariable int studentId) {
        if (studentId < 0 || studentId >= students.size()) {
            throw new StudentNotFoundException("Student ID not found - " + studentId);
        }
        return students.get(studentId);
    }

}
