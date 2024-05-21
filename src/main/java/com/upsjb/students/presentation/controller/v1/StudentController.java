package com.upsjb.students.presentation.controller.v1;

import com.upsjb.students.presentation.dto.v1.StudentDTO;
import com.upsjb.students.service.useCase.IStudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final IStudentService studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudent(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Student with id " + id);

    }
    @GetMapping("/all")
    public ResponseEntity<List<StudentDTO>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @PostMapping()
    public ResponseEntity<StudentDTO> addStudent(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.addStudent(studentDTO));
    };

    @PutMapping("/{id}")
    public ResponseEntity<StudentDTO> updateStudent(@RequestBody StudentDTO studentDTO, @PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(studentService.updateStudent(studentDTO,id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable(name = "id") Long id) {
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(studentService.deleteStudent(id));
    }

}
