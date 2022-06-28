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

    public Optional<Hospital> getHospitalById(String id) {
        return hospitalRepository.findById(id);
    }


    public String addHospital(AddHospital newHospital) {

        Hospital hospital = new Hospital();

        int one = (int) UUID.randomUUID().toString().charAt(0);
        int two = (int) UUID.randomUUID().toString().charAt(0);
        String newId = "h" + one + two;
        hospital.setH_id(newId);

        hospital.setName(newHospital.getName());
        hospital.setAddress(newHospital.getAddress());
        hospital.setAmbulances(newHospital.getAmbulances());
        hospital.setWards(newHospital.getWards());

        hospitalRepository.save(hospital);
        return newId;
    }

    public boolean deleteHospitalById(String id) {
        Optional<Hospital> data = hospitalRepository.findById(id);
        if (data.isPresent()) {
            hospitalRepository.delete(data.get());
            return true;
        }
        return false;
    }

    public void updateHospital(Hospital updateHospital) {
        hospitalRepository.save(updateHospital);
    }

}
