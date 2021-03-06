package com.spring.health.hospital.Service;

import com.spring.health.hospital.Model.Patient;
import com.spring.health.hospital.Model.RequestModel.AddPatient;
import com.spring.health.hospital.Repository.DoctorRepository;
import com.spring.health.hospital.Repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class PatientService {
    @Autowired
    PatientRepository patientRepository;

    @Autowired
    DoctorRepository doctorRepository;

    public Iterable<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> getPatientById(String id) {
        return patientRepository.findById(id);
    }

    public String addPatient(AddPatient newPatient) {
        Patient patient = new Patient();
        patient.setDoctor(doctorRepository.findById(newPatient.getD_id()).get());
        int one = (int) UUID.randomUUID().toString().charAt(0);
        int two = (int) UUID.randomUUID().toString().charAt(0);
        String newId = "p" + one + two;
        patient.setP_id(newId);

        patient.setFirstName(newPatient.getFirstName());
        patient.setLastName(newPatient.getLastName());
        patient.setDisease(newPatient.getDisease());
        patient.setEmail(newPatient.getEmail());
        patient.setAge(newPatient.getAge());
        patient.setGender(newPatient.getGender());

        patientRepository.save(patient);
        return newId;
    }

    public boolean deletePatientById(String id) {
        Optional<Patient> data = patientRepository.findById(id);
        if (data.isPresent()) {
            patientRepository.delete(data.get());
            return true;
        }
        return false;
    }

    public void updatePatient(Patient updatePatient) {
        patientRepository.save(updatePatient);
    }

}
