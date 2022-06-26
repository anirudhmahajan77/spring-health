package com.spring.health.hospital.Controller;

import com.spring.health.hospital.Model.Doctor;
import com.spring.health.hospital.Model.RequestModel.AddDoctor;
import com.spring.health.hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    DoctorService doctorService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity getAllDoctors() {
        Iterable<Doctor> response = doctorService.getAllDoctors();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getDoctorById(@PathVariable String id) {
        Doctor response = doctorService.getDoctorById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNewDoctor(@RequestBody AddDoctor doctor) {
        doctorService.addDoctor(doctor);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoctorById(@PathVariable String id) {
        doctorService.deleteDoctorById(id);
        return new ResponseEntity(HttpStatus.OK);
    }


}
