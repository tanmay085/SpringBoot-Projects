package com.project.hospital.management.controller;

import com.project.hospital.management.dto.PatientDto;
import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/{id}/patient")
    public PatientDto createPatient(@PathVariable Long id, @RequestBody PatientDto patientDto){
        return this.patientService.createPatient(id,patientDto);
    }

    @GetMapping("/{id}/patient")
    public List<Appointment> getAppointmentByPatient(@PathVariable Long id){
        return this.patientService.getAppointmentByPatient(id);
    }

}
