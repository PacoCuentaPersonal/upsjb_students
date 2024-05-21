package com.upsjb.students.persistence.dao.implementation;

import com.upsjb.students.persistence.dao.interfaces.IFactultyDAO;
import com.upsjb.students.persistence.entity.Faculty;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class IFacultyDAOImpl  implements IFactultyDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Optional<Faculty> getFacultyById(int id) {
        return Optional.ofNullable(this.em.find(Faculty.class, id));
    }
    @Transactional
    @Override
    public List<Faculty> getAllFaculty() {
        return this.em.createQuery("select f from Faculty f").getResultList();
    }

    @Override
    public void addFaculty(Faculty faculty) {
        this.em.persist(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        this.em.merge(faculty);

    }

    @Override
    public void deleteFaculty(Faculty faculty) {
        this.em.remove(faculty);
    }

    @Override
    public Optional<Faculty> getFacultyByName(String facultyName) {
        try {
            TypedQuery<Faculty> query= this.em.createQuery("SELECT f FROM Faculty AS f WHERE f.facultyName = :facultyName", Faculty.class);
            query.setParameter("facultyName", facultyName);
            return Optional.ofNullable(query.getSingleResult());
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
