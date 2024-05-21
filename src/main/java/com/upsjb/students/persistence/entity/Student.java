package com.upsjb.students.persistence.entity;

import jakarta.persistence.*;
import lombok.Builder;

import java.time.ZonedDateTime;

@Builder
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String student_code;
    private ZonedDateTime registration_date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_faculty", nullable = false)
    private Faculty faculty_student;


    public Student(Long id, String student_code, ZonedDateTime registration_date, Faculty faculty_student) {
        this.id = id;
        this.student_code = student_code;
        this.registration_date = registration_date;
        this.faculty_student = faculty_student;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent_code() {
        return student_code;
    }

    public void setStudent_code(String student_code) {
        this.student_code = student_code;
    }

    public ZonedDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(ZonedDateTime registration_date) {
        this.registration_date = registration_date;
    }

    public Faculty getFaculty_student() {
        return faculty_student;
    }

    public void setFaculty_student(Faculty faculty_student) {
        this.faculty_student = faculty_student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student_code='" + student_code + '\'' +
                ", registration_date=" + registration_date +
                ", faculty_student=" + faculty_student +
                '}';
    }
}
