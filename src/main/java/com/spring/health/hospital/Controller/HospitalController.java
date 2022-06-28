package com.spring.health.hospital.Controller;

import com.spring.health.hospital.Model.Hospital;
import com.spring.health.hospital.Model.RequestModel.AddHospital;
import com.spring.health.hospital.Service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        Optional<Hospital> response = hospitalService.getHospitalById(id);
        if (response.isPresent()) {
            return new ResponseEntity<>(response.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity addNewHospital(@RequestBody AddHospital hospital) {
        String id = hospitalService.addHospital(hospital);
        return new ResponseEntity(id, HttpStatus.OK);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteHospitalById(@PathVariable String id) {
        boolean response = hospitalService.deleteHospitalById(id);
        if (response) {
            return new ResponseEntity(HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public ResponseEntity updateHospital(@RequestBody Hospital updateHospital) {
        hospitalService.updateHospital(updateHospital);
        return new ResponseEntity(HttpStatus.OK);
    }

}
