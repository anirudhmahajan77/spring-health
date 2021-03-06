package com.spring.health.hospital.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(name = "delete" , query = "UPDATE patient SET doctor = null WHERE p_id = :id")
public class Patient {

    @Id
    String p_id;

    @Column(name = "first_name")
    String firstName;

    @Column(name = "last_name")
    String lastName;

    String email;
    String disease;
    Integer age;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "doctor_fk", referencedColumnName = "d_id")
    Doctor doctor;
}
