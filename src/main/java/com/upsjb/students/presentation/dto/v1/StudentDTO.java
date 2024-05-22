package com.upsjb.students.presentation.dto.v1;

import jakarta.annotation.Nullable;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class StudentDTO {
    @Nullable
    private Long id;
    private String student_code;
    private String faculty_name;
}
