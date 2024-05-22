package com.upsjb.students.persistence.dao.implementation;

import com.upsjb.students.persistence.dao.interfaces.IStudentDAO;
import com.upsjb.students.persistence.entity.Faculty;
import com.upsjb.students.persistence.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class IStudentDAOImpl implements IStudentDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        List<Object[]> results = this.em.createQuery("SELECT s.id, s.student_code, s.registration_date, f.id, f.facultyName, f.facultyCode FROM Student s INNER JOIN s.faculty_student f", Object[].class).getResultList();
        List<Student> students = new ArrayList<>();
        for (Object[] result : results) {
            Student student = new Student();
            student.setId((Long) result[0]);
            student.setStudent_code((String) result[1]);
            student.setRegistration_date((LocalDateTime) result[2]);

            Faculty faculty = new Faculty();
            faculty.setId((Long) result[3]);
            faculty.setFacultyName((String) result[4]);

            student.setFaculty_student(faculty);

            students.add(student);
        }
        return students;
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<Student> getStudentById(Long id) {
        return Optional.ofNullable(this.em.find(Student.class, id));
    }

    @Transactional(readOnly = false)
    @Override
    public void saveUser(Student student) {
        this.em.persist(student);
        this.em.flush();
    }
    @Transactional(readOnly = false)
    @Override
    public void updateStudent(Student student) {
        this.em.merge(student);
    }
    @Transactional(readOnly = false)
    @Override
    public void deleteStudent(Student student) {
        this.em.remove(student);

    }
}
