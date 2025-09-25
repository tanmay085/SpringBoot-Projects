package com.project.hospital.management.service;

import com.project.hospital.management.dto.AppointmentDto;
import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.entity.Doctor;
import com.project.hospital.management.entity.Patient;
import com.project.hospital.management.repository.AppointmentRepository;
import com.project.hospital.management.repository.DoctorRepository;
import com.project.hospital.management.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;

    public AppointmentDto createAppointment(Long dId, Long pId, AppointmentDto appointmentDto){
        Appointment appointment=new Appointment();
        Doctor doctor= doctorRepository.findById(dId).get();
        appointment.setDoctor(doctor);
        Patient patient=patientRepository.findById(pId).get();
        appointment.setPatient(patient);
        appointment.setReason(appointmentDto.getReason());
        appointmentRepository.save(appointment);
        return appointmentDto;

    }
}
