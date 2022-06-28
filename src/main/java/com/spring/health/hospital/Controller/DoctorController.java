package com.spring.health.hospital.Controller;

import com.spring.health.hospital.Model.Doctor;
import com.spring.health.hospital.Model.RequestModel.AddDoctor;
import com.spring.health.hospital.Service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Optional<Doctor> response = doctorService.getDoctorById(id);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNewDoctor(@RequestBody AddDoctor doctor) {
        String id = doctorService.addDoctor(doctor);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDoctorById(@PathVariable String id) {
        boolean response = doctorService.deleteDoctorById(id);
        if (response) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }


    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateDoctor(@RequestBody Doctor updatedDoctor) {
        doctorService.updateDoctor(updatedDoctor);
        return new ResponseEntity(HttpStatus.OK);
    }

}
