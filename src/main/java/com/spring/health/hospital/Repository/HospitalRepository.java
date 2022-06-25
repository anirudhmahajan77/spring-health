package com.spring.health.hospital.Repository;

import com.spring.health.hospital.Model.Hospital;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, String> {
}
