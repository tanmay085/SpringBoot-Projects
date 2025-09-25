package com.project.hospital.management.service;

import com.project.hospital.management.dto.PatientDto;
import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.entity.Insurance;
import com.project.hospital.management.entity.Patient;
import com.project.hospital.management.repository.AppointmentRepository;
import com.project.hospital.management.repository.InsuranceRepository;
import com.project.hospital.management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private InsuranceRepository insuranceRepository;
    @Autowired
    private AppointmentRepository appointmentRepository;



    public PatientDto createPatient(Long id,PatientDto patientDto){
        Patient patient=new Patient();
        Insurance insurance=insuranceRepository.findById(id).get();
        patient.setInsurance(insurance);
        patient.setName(patientDto.getName());
        patient.setBirthdate(patientDto.getBirthDate());
        patient.setGender(patientDto.getGender());
        patient.setEmail(patientDto.getEmail());
        patientRepository.save(patient);
        return patientDto;
    }

    public List<Appointment> getAppointmentByPatient(Long id){
        Patient patient=patientRepository.findById(id).get();
        return appointmentRepository.findByPatient(patient);
    }
}
