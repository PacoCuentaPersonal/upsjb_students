package com.upsjb.students.persistence.dao.interfaces;

import com.upsjb.students.persistence.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentDAO {
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    void saveUser(Student student);
    void updateStudent(Student student);
    void deleteStudent(Student student);
}
