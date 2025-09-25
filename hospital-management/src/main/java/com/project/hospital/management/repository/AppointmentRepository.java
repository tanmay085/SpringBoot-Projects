package com.project.hospital.management.repository;

import com.project.hospital.management.entity.Appointment;
import com.project.hospital.management.entity.Doctor;
import com.project.hospital.management.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
    public List<Appointment> findByDoctor(Doctor doctor);
    public List<Appointment>findByPatient(Patient patient);
}
