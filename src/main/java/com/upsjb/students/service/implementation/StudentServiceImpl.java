package com.upsjb.students.service.implementation;

import com.upsjb.students.persistence.dao.interfaces.IFactultyDAO;
import com.upsjb.students.persistence.dao.interfaces.IStudentDAO;
import com.upsjb.students.persistence.entity.Faculty;
import com.upsjb.students.persistence.entity.Student;
import com.upsjb.students.presentation.dto.v1.StudentDTO;
import com.upsjb.students.service.useCase.IStudentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl  implements IStudentService {
    private final IStudentDAO studentDAO;
    private final IFactultyDAO factultyDAO;

    public StudentServiceImpl(IStudentDAO studentDAO, IFactultyDAO factultyDAO) {
        this.studentDAO = studentDAO;
        this.factultyDAO = factultyDAO;
    }


    @Override
    public List<StudentDTO> getAllStudents() {
         ModelMapper mp= new ModelMapper();
         return studentDAO.getAllStudents()
                 .stream()
                 .map(entity-> mp.map(entity,StudentDTO.class))
                 .collect(Collectors.toList());
    }

    @Override
    public StudentDTO getStudentById(Long id) {
        Optional<Student> StudentOptional=this.studentDAO.getStudentById(id);
        if(StudentOptional.isPresent()){
            ModelMapper mp= new ModelMapper();
            Student Student=StudentOptional.get();
            return mp.map(Student,StudentDTO.class);
        }
        else {
            return new StudentDTO();
        }
    }

    @Override
    public StudentDTO addStudent(StudentDTO studentDTO) {
        ModelMapper mp= new ModelMapper();
        try {
            this.studentDAO.saveUser(mp.map(studentDTO,Student.class));
            return studentDTO;
        }
        catch (Exception e){
            throw new RuntimeException(e);

        }
    }

    @Override
    public StudentDTO updateStudent(StudentDTO studentDTO, Long id) {
        Optional<Student> studentOptional=this.studentDAO.getStudentById(id);
        if(studentOptional.isPresent()){
            Student student=studentOptional.get();
            student.setStudent_code(studentDTO.getCode_student());
            //logic to update faculty associated a student
            Optional<Faculty> facultyOptional=this.factultyDAO.getFacultyByName(studentDTO.getFaculty_name());
            Faculty faculty=facultyOptional.get();
            student.setFaculty_student(faculty);
            //merge
            this.studentDAO.updateStudent(student);
            ModelMapper mp= new ModelMapper();
            return mp.map(student,StudentDTO.class);
        }
        else {
            throw new RuntimeException("Student not found");
        }


    }

    @Override
    public String deleteStudent(Long id) {
        Optional<Student> studentOptional=this.studentDAO.getStudentById(id);
        if(studentOptional.isPresent()){
            Student student=studentOptional.get();
            this.studentDAO.deleteStudent(student);
            return "Student deleted"+student.getStudent_code();
        }
        else {
            throw new RuntimeException("Student not found");
        }
    }
}
