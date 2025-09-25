package com.project.hospital.management.service;

import com.project.hospital.management.dto.InsuranceDto;
import com.project.hospital.management.entity.Insurance;
import com.project.hospital.management.repository.InsuranceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InsuranceService {

    @Autowired
    private InsuranceRepository insuranceRepository;


    public InsuranceDto createInsurance(InsuranceDto insuranceDto){
        Insurance insurance=new Insurance();
        insurance.setProvider(insuranceDto.getProvider());
        insurance.setPolicyNumber(insuranceDto.getPolicyNumber());
        insuranceRepository.save(insurance);
        return insuranceDto;
    }

}
