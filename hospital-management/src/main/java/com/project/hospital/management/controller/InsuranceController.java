package com.project.hospital.management.controller;

import com.project.hospital.management.dto.InsuranceDto;
import com.project.hospital.management.service.InsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;


    @PostMapping("/insurance")
    public InsuranceDto createInsurance(@RequestBody InsuranceDto insuranceDto){
        return this.insuranceService.createInsurance(insuranceDto);
    }

}
