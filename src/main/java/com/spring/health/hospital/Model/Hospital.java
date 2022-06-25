package com.spring.health.hospital.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "hospital")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Hospital {

    @Id
    String h_id;

    String name;
    String address;
    Integer wards;
    Integer ambulances;
}
