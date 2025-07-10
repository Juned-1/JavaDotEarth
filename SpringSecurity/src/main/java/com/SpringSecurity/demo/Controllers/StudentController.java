package com.SpringSecurity.demo.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringSecurity.demo.Model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
    //We should build Service layer and Repository layer
    //But for simplicity of security now, we will skip. In actual application it should be done.
    

    private List<Student> students = new ArrayList<>(List.of(
        new Student(1, "John Doe", 85),
        new Student(2, "Jane Smith", 90),
        new Student(3, "Alice Johnson", 78),
        new Student(4, "Bob Brown", 88),
        new Student(5, "Charlie White", 92)

    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @GetMapping("csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        students.add(student);
        return student;
    }
}
