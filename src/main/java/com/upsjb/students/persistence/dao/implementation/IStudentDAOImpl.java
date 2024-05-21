package com.upsjb.students.persistence.dao.implementation;

import com.upsjb.students.persistence.dao.interfaces.IStudentDAO;
import com.upsjb.students.persistence.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class IStudentDAOImpl implements IStudentDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return this.em.createQuery("SELECT u FROM Student AS u").getResultList();
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
