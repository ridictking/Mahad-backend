package io.ridsoftinformatiks.mahad.controller;

import io.ridsoftinformatiks.mahad.models.Student;
import io.ridsoftinformatiks.mahad.models.response.StudentResponse;
import io.ridsoftinformatiks.mahad.models.response.StudentResponseList;
import io.ridsoftinformatiks.mahad.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:5000"})
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public StudentResponseList getStudents(@RequestParam(name = "pageNum", required = false, defaultValue = "0") int pageNum, @RequestParam(name = "pageSize", required = false, defaultValue = "10") int pageSize) {
        if(pageNum > 0){
            pageNum = pageNum-1;
        }
        return studentService.getAllStudent(pageNum,pageSize);
    }
    @PostMapping("/")
    public ResponseEntity<StudentResponse> saveStudent(@RequestBody @Validated Student student){
        StudentResponse studentResponse = studentService.saveStudent(student);
        if(studentResponse.getCode().equalsIgnoreCase("409")){
            return new ResponseEntity<>(studentResponse, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(studentResponse, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentResponse> getStudentById(@PathVariable(value = "id") Long id){
        StudentResponse studentById = studentService.getStudentById(id);
        return  new ResponseEntity<>(studentById, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentResponse> updateStudent(@PathVariable(value = "id") Long id,@Validated @RequestBody Student student){
        StudentResponse studentResponse = studentService.updateStudent(student,id);
        return new ResponseEntity<>(studentResponse, HttpStatus.OK);
    }
}
