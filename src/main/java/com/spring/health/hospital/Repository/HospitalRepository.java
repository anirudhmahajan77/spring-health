package com.spring.health.hospital.Repository;

import com.spring.health.hospital.Controller.HospitalController;
import com.spring.health.hospital.Model.Hospital;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository extends CrudRepository<Hospital, String> {
}
