package com.spring.health.hospital.Model.RequestModel;

import com.spring.health.hospital.Model.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddDoctor {
    String firstName;
    String lastName;
    String email;
    String type;
    Integer experience;
    Integer age;
    String h_id;
    Gender gender;
}