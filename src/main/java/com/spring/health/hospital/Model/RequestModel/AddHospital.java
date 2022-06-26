package com.spring.health.hospital.Model.RequestModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddHospital {
    String name;
    String address;
    Integer wards;
    Integer ambulances;
}
