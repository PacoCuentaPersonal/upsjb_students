package com.upsjb.students.presentation.dto.v1;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    private Long id;
    private String code_student;
    private String faculty_name;
}
