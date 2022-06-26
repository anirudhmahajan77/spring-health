package com.spring.health.hospital.Service;

import com.spring.health.hospital.Model.Hospital;
import com.spring.health.hospital.Model.RequestModel.AddHospital;
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


    public void addHospital(AddHospital newHospital) {

        Hospital hospital = new Hospital();

        int one = (int) UUID.randomUUID().toString().charAt(0);
        int two = (int) UUID.randomUUID().toString().charAt(0);
        hospital.setH_id("h" + one + two);

        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        hospital.setAmbulances(newHospital.getAmbulances());
        hospital.setWards(newHospital.getWards());

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

    public void updateHospital(Hospital updateHospital){
        hospitalRepository.save(updateHospital);
    }

}
