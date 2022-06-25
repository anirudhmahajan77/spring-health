package com.spring.health.hospital.Controller;

import com.spring.health.hospital.Model.Hospital;
import com.spring.health.hospital.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/hospital")
public class HospitalController {

    @Autowired
    private HospitalService hospitalService;

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity getAllHospitals() {
        Iterable<Hospital> response = hospitalService.getAllHospitals();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ResponseEntity getHospitalById(@PathVariable String id) {
        Hospital response = hospitalService.getHospitalById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNewHospital(@RequestBody Hospital hospital) {
        hospitalService.addHospital(hospital);
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteHospitalById(@PathVariable String id){
        hospitalService.deleteHospitalById(id);
        return new ResponseEntity(HttpStatus.OK);
    }

}
