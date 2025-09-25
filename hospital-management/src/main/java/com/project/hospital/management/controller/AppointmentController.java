package com.project.hospital.management.controller;

import com.project.hospital.management.dto.AppointmentDto;
import com.project.hospital.management.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("/{dId}/{pId}/appointment")
    public AppointmentDto createAppointment(@PathVariable Long dId, @PathVariable Long pId, @RequestBody AppointmentDto appointmentDto){
        return this.appointmentService.createAppointment(dId,pId,appointmentDto);
    }


}
