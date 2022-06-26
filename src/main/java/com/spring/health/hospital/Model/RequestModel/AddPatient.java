package com.spring.health.hospital.Model.RequestModel;

import com.spring.health.hospital.Model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddPatient {
    String firstName;
    String lastName;
    String email;
    String disease;
    Integer age;
    String d_id;
    Gender gender;
}