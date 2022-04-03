package com.deadlifter.controller;

import com.deadlifter.entity.Student;
import com.deadlifter.request.CreateStudentRequest;
import com.deadlifter.request.UpdateStudentRequest;
import com.deadlifter.response.StudentResponse;
import com.deadlifter.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

//    @Value("${app.name:Default app name}")
//    private String appName;

    @GetMapping("/")
    public List<StudentResponse> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        List<StudentResponse> studentResponses = students.stream().map(StudentResponse::new).collect(Collectors.toList());
        return studentResponses;
    }

    @PostMapping("/")
    public StudentResponse createStudent(@Valid @RequestBody CreateStudentRequest createStudentRequest) {
        Student student = studentService.createStudent(createStudentRequest);
        return new StudentResponse(student);
    }

    @PutMapping("/")
    public StudentResponse updateStudent(@Valid @RequestBody UpdateStudentRequest updateStudentRequest) {
        Student student = studentService.updateStudent(updateStudentRequest);
        return new StudentResponse(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id);
    }

}
