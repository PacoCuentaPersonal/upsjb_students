package com.upsjb.students.persistence.entity;

import com.upsjb.students.StudentsApplication;
import jakarta.persistence.*;
import lombok.Builder;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;

@EntityListeners(AuditingEntityListener.class)
@Builder
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20)
    private String student_code;
    @CreatedDate
    private LocalDateTime registration_date;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="id_faculty", nullable = false)
    private Faculty faculty_student;


    public Student(Long id, String student_code, LocalDateTime time, Faculty faculty_student) {
        this.registration_date=time;
        this.id = id;
        this.student_code = student_code;
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

    public LocalDateTime getRegistration_date() {
        return registration_date;
    }

    public void setRegistration_date(LocalDateTime registration_date) {
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
