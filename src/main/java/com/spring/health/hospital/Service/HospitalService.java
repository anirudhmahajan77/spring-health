package com.spring.health.hospital.Service;

import com.spring.health.hospital.Repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HospitalService {

    @Autowired
    public HospitalRepository hospitalRepository;

}
