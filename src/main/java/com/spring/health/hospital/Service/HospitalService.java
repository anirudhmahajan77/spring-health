package com.spring.health.hospital.Service;

import com.spring.health.hospital.Model.Hospital;
import com.spring.health.hospital.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class HospitalService {

    @Autowired
    public HospitalRepository hospitalRepository;

    public Iterable<Hospital> getAllHospitals() {
        return hospitalRepository.findAll();
    }

    public Hospital getHospitalById(String id) {
        Optional<Hospital> response = hospitalRepository.findById(id);
        return response.get();
    }


    public void addHospital(Hospital hospital) {
        int one = (int) UUID.randomUUID().toString().charAt(0);
        int two = (int) UUID.randomUUID().toString().charAt(0);
        hospital.setH_id("h" + one + two);
        hospitalRepository.save(hospital);
    }

    public int deleteHospitalById(String id) {
        Optional<Hospital> data = hospitalRepository.findById(id);
        if(data.isPresent()){
            hospitalRepository.delete(data.get());
            return 1;
        }
        return 0;
    }

}
