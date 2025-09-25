package com.project.hospital.management.controller;

import com.project.hospital.management.dto.DoctorDto;
import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.service.AppointmentService;
import com.project.hospital.management.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor")
    public DoctorDto createDoctor(@RequestBody DoctorDto doctorDto){
        return this.doctorService.createDoctor(doctorDto);
    }

    @GetMapping("/{id}/doctor")
    public List<Appointment> getAppointmentByDoctor(@PathVariable Long id){
        return this.doctorService.getAppointmentByDoctor(id);
    }


}
