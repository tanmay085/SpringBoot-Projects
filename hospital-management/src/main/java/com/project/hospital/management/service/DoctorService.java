package com.project.hospital.management.service;

import com.project.hospital.management.dto.DoctorDto;
import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.entity.Doctor;
import com.project.hospital.management.repository.AppointmentRepository;
import com.project.hospital.management.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import javax.print.Doc;
import java.util.List;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private AppointmentRepository  appointmentRepository;

    public DoctorDto createDoctor(DoctorDto doctorDto){
        Doctor doctor=new Doctor();
        doctor.setName(doctorDto.getName());
        doctor.setEmail(doctorDto.getEmail());
        doctor.setSpecialization(doctorDto.getSpecialization());
        doctorRepository.save(doctor);
        return doctorDto;

    }

    public List<Appointment> getAppointmentByDoctor(Long id){
        Doctor doctor=doctorRepository.findById(id).get();
        return appointmentRepository.findByDoctor(doctor);
    }
}
