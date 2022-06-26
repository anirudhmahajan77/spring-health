package com.spring.health.hospital.Service;

import com.spring.health.hospital.Model.Doctor;
import com.spring.health.hospital.Model.RequestModel.AddDoctor;
import com.spring.health.hospital.Repository.DoctorRepository;
import com.spring.health.hospital.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    HospitalRepository hospitalRepository;

    public Iterable<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    public Doctor getDoctorById(String id) {
        Optional<Doctor> response = doctorRepository.findById(id);
        return response.get();
    }

    public void addDoctor(AddDoctor newdoctor) {
        Doctor doctor = new Doctor();
        doctor.setHospital(hospitalRepository.findById(newdoctor.getH_id()).get());
        int one = (int) UUID.randomUUID().toString().charAt(0);
        int two = (int) UUID.randomUUID().toString().charAt(0);
        doctor.setD_id("d" + one + two);
        doctor.setFirstName(newdoctor.getFirstName());
        doctor.setLastName(newdoctor.getLastName());
        doctor.setType(newdoctor.getType());
        doctor.setEmail(newdoctor.getEmail());
        doctor.setAge(newdoctor.getAge());
        doctor.setExperience(newdoctor.getExperience());
        doctor.setGender(newdoctor.getGender());

        doctorRepository.save(doctor);
    }

    public int deleteDoctorById(String id) {
        Optional<Doctor> data = doctorRepository.findById(id);
        if (data.isPresent()) {
            data.get().setHospital(null);
            doctorRepository.save(data.get());
            doctorRepository.delete(data.get());
            return 1;
        }
        return 0;
    }

    public void updateDoctor(Doctor updatedDoctor) {
        doctorRepository.save(updatedDoctor);
    }

}