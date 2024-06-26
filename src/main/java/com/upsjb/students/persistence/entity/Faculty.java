package com.upsjb.students.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.List;
@Builder
@Entity
@Table(name = "faculty_table")
public class Faculty {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 150)
    private String facultyName;
    @Column(length = 20)
    private String facultyCode;

    @OneToMany(mappedBy = "faculty_student")
    private List<Student> studentList;

    public Faculty(Long id, String facultyName, String facultyCode, List<Student> studentList) {
        this.id = id;
        this.facultyName = facultyName;
        this.facultyCode = facultyCode;
        this.studentList = studentList;
    }

    public Faculty() {
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "id=" + id +
                ", facultyName='" + facultyName + '\'' +
                ", facultyCode='" + facultyCode + '\'' +
                ", studentList=" + studentList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyCode() {
        return facultyCode;
    }

    public void setFacultyCode(String facultyCode) {
        this.facultyCode = facultyCode;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }
}
