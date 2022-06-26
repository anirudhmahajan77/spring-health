package com.spring.health.hospital.Controller;

import com.spring.health.hospital.Model.Patient;
import com.spring.health.hospital.Model.RequestModel.AddPatient;
import com.spring.health.hospital.Service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    PatientService patientService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity getAllPatients() {
        Iterable<Patient> response = patientService.getAllPatients();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getPatientById(@PathVariable String id) {
        Patient response = patientService.getPatientById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNewPatient(@RequestBody AddPatient patient) {
        patientService.addPatient(patient);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deletePatientById(@PathVariable String id) {
        boolean result = patientService.deletePatientById(id);
        if(!result){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updatePatient(@RequestBody Patient updatedPatient){
        patientService.updatePatient(updatedPatient);
        return new ResponseEntity(HttpStatus.OK);
    }

}
