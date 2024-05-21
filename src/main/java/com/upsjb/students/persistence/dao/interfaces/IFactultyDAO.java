package com.upsjb.students.persistence.dao.interfaces;

import com.upsjb.students.persistence.entity.Faculty;

import java.util.List;
import java.util.Optional;

public interface IFactultyDAO {
    public Optional<Faculty> getFacultyById(int id);
    public List<Faculty> getAllFaculty();
    public void addFaculty(Faculty faculty);
    public void updateFaculty(Faculty faculty);
    public void deleteFaculty(Faculty faculty);
    public Optional<Faculty> getFacultyByName(String facultyName);
}
