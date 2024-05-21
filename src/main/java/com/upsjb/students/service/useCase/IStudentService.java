package com.upsjb.students.service.useCase;

import com.upsjb.students.presentation.dto.v1.StudentDTO;

import java.util.List;

public interface IStudentService {
    List<StudentDTO> getAllStudents();
    StudentDTO getStudentById(Long id);
    StudentDTO addStudent(StudentDTO studentDTO);
    StudentDTO updateStudent(StudentDTO studentDTO, Long id);
    String deleteStudent(Long id);
}
